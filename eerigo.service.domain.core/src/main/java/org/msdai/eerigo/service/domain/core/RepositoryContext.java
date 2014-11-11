package org.msdai.eerigo.service.domain.core;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/1/14
 * Time: 2:19 PM
 * 仓储上下文接口
 */
public interface RepositoryContext extends UnitOfWork {
    /**
     * 获取仓储上下文的全局唯一标识
     * */
    UUID getID();

    /**
     * 将指定的聚合根标注为“New”状态，供Commit
     * */
    <TAggregateRoot extends AggregateRootBase> void registerNew(TAggregateRoot obj) throws EerigoRepositoryConcurrentModificationException;

    /**
     * 将指定的聚合根标注为“Modified”状态，供Commit
     * */
    <TAggregateRoot extends AggregateRootBase> void registerModified(TAggregateRoot obj) throws EerigoRepositoryConcurrentModificationException;

    /**
     * 将指定的聚合根标注为“Deleted”状态，供Commit
     * */
    <TAggregateRoot extends AggregateRootBase> void registerDeleted(TAggregateRoot obj) throws EerigoRepositoryConcurrentModificationException;
}