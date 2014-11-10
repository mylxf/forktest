package org.msdai.eerigo.service.domain.core;

import org.msdai.eerigo.core.exception.RepositoryConcurrentModificationException;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 3/31/14
 * Time: 4:43 PM
 * 工作单元接口
 */
public interface UnitOfWork {
    /**
     * 事务是否已提交
     */
    boolean isCommitted();

    /**
     * 事务提交
     */
    void commit() throws RepositoryConcurrentModificationException;

    /**
     * 事务回滚
     */
    void rollback();
}
