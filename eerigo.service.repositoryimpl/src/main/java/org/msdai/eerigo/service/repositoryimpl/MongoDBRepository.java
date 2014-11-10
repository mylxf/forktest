package org.msdai.eerigo.service.repositoryimpl;

import org.msdai.eerigo.core.exception.RepositoryConcurrentModificationException;
import org.msdai.eerigo.service.domain.core.AggregateRootBase;
import org.msdai.eerigo.service.domain.core.Repository;
import org.msdai.eerigo.service.domain.core.RepositoryContext;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/4/14
 * Time: 11:03 AM
 */
public abstract class MongoDBRepository<TAggregateRoot extends AggregateRootBase> implements Repository<TAggregateRoot> {

    private MongoDBRepositoryContext mongoDBRepositoryContext;

    protected MongoDBRepositoryContext getMongoDBRepositoryContext() {
        return mongoDBRepositoryContext;
    }

    public MongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        this.mongoDBRepositoryContext = mongoDBRepositoryContext;
    }

    @Override
    public RepositoryContext getContext() {
        return mongoDBRepositoryContext;
    }

    @Override
    public void add(TAggregateRoot item) throws RepositoryConcurrentModificationException {
        mongoDBRepositoryContext.registerNew(item);
    }

    @Override
    public void remove(TAggregateRoot item) throws RepositoryConcurrentModificationException {
        mongoDBRepositoryContext.registerDeleted(item);
    }

    @Override
    public void update(TAggregateRoot item) throws RepositoryConcurrentModificationException {
        mongoDBRepositoryContext.registerModified(item);
    }
}