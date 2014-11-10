package org.msdai.eerigo.service.repositoryimpl;


import org.msdai.eerigo.service.domain.core.AggregateRoot;
import org.msdai.eerigo.service.domain.core.AggregateRootBase;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.msdai.eerigo.core.exception.RepositoryConcurrentModificationException;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/4/14
 * Time: 2:02 PM
 */
public class DefaultMongoDBRepositoryContext implements MongoDBRepositoryContext {

    private MongoOperations mongoOperations;

    private final UUID id = UUID.randomUUID();
    private final Object syncObject = new Object();

    private ThreadLocal<List<AggregateRootBase>> localNewCollection = new ThreadLocal<List<AggregateRootBase>>();
    private ThreadLocal<List<AggregateRootBase>> localModifiedCollection = new ThreadLocal<List<AggregateRootBase>>();
    private ThreadLocal<List<AggregateRootBase>> localDeletedCollection = new ThreadLocal<List<AggregateRootBase>>();
    private ThreadLocal<Boolean> localCommitted = new ThreadLocal<Boolean>();

    public DefaultMongoDBRepositoryContext(MongoDBRepositoryContextSettings mongoDBRepositoryContextSettings) {
        mongoOperations = mongoDBRepositoryContextSettings.getDB();
    }

    private void clearRegistrations() {
        localNewCollection = new ThreadLocal<List<AggregateRootBase>>();
        localNewCollection.set(new ArrayList<AggregateRootBase>());
        localModifiedCollection = new ThreadLocal<List<AggregateRootBase>>();
        localModifiedCollection.set(new ArrayList<AggregateRootBase>());
        localDeletedCollection = new ThreadLocal<List<AggregateRootBase>>();
        localDeletedCollection.set(new ArrayList<AggregateRootBase>());
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public <TAggregateRoot extends AggregateRootBase> void registerNew(TAggregateRoot obj) throws RepositoryConcurrentModificationException {
        newThreadPreCheck();
        localNewCollection.get().add(obj);
        localCommitted.set(false);
    }

    @Override
    public <TAggregateRoot extends AggregateRootBase> void registerModified(TAggregateRoot obj) throws RepositoryConcurrentModificationException {
        newThreadPreCheck();
        if (localDeletedCollection.get().contains(obj))
            throw new RepositoryConcurrentModificationException("The object cannot be registered as a modified object since it was marked as deleted.");
        if (!localModifiedCollection.get().contains(obj) && !localNewCollection.get().contains(obj)) {
            localModifiedCollection.get().add(obj);
            localCommitted.set(false);
        }
    }

    @Override
    public <TAggregateRoot extends AggregateRootBase> void registerDeleted(TAggregateRoot obj) throws RepositoryConcurrentModificationException {
        newThreadPreCheck();
        if (localNewCollection.get().contains(obj)) {
            localNewCollection.get().remove(obj);
            return;
        }
        boolean removedFromModified = false;
        if (localModifiedCollection.get().contains(obj)) {
            localModifiedCollection.get().remove(obj);
            removedFromModified = true;
        }
        boolean addedToDeleted = false;
        if (!localDeletedCollection.get().contains(obj)) {
            localDeletedCollection.get().add(obj);
            addedToDeleted = true;
        }
        localCommitted.set(!(removedFromModified || addedToDeleted));
    }

    @Override
    public boolean isCommitted() {
        return localCommitted.get();
    }

    @Override
    public void commit() throws RepositoryConcurrentModificationException {
        synchronized (syncObject) {
            for (AggregateRootBase newObject : localNewCollection.get()) {
                mongoOperations.insert(newObject);
            }

            for (AggregateRootBase modifiedObject : localModifiedCollection.get()) {
                Query query = new Query(Criteria.where("_id").is(modifiedObject.getId()).andOperator(Criteria.where("seq").is(modifiedObject.getSeq())));
                long count = mongoOperations.count(query, modifiedObject.getClass());
                if (count > 0) {
                    modifiedObject.updateSeq();
                    mongoOperations.save(modifiedObject);
                } else {
                    throw new RepositoryConcurrentModificationException("this transaction can't be commit , object modified by other thread");
                }
            }

            for (AggregateRootBase deletedObject : localDeletedCollection.get()) {
                Query query = new Query(Criteria.where("_id").is(deletedObject.getId()).andOperator(Criteria.where("seq").is(deletedObject.getSeq())));
                AggregateRoot aggregateRoot = mongoOperations.findAndRemove(query, deletedObject.getClass());
                if (aggregateRoot == null) {
                    throw new RepositoryConcurrentModificationException("this transaction can't be commit , object modified by other thread");
                }
            }
            clearRegistrations();
            localCommitted.set(true);
        }
    }

    private void newThreadPreCheck() {
        if (localNewCollection.get() == null) {
            localNewCollection.set(new ArrayList<AggregateRootBase>());
        }
        if (localModifiedCollection.get() == null) {
            localModifiedCollection.set(new ArrayList<AggregateRootBase>());
        }
        if (localDeletedCollection.get() == null) {
            localDeletedCollection.set(new ArrayList<AggregateRootBase>());
        }
    }

    @Override
    public void rollback() {
        localCommitted.set(false);
    }

    @Override
    public MongoOperations getDB() {
        return mongoOperations;
    }
}
