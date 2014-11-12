package org.msdai.eerigo.service.repositoryimpl;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;
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
    public void insert(TAggregateRoot item) throws EerigoRepositoryConcurrentModificationException {
        mongoDBRepositoryContext.registerNew(item);
    }

    @Override
    public void delete(TAggregateRoot item) throws EerigoRepositoryConcurrentModificationException {
        mongoDBRepositoryContext.registerDeleted(item);
    }

    @Override
    public void update(TAggregateRoot item) throws EerigoRepositoryConcurrentModificationException {
        mongoDBRepositoryContext.registerModified(item);
    }
}