package org.msdai.eerigo.service.domain.core;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 3/31/14
 * Time: 4:44 PM
 * 仓储接口（所有使用仓储的前提是实体必须是聚合根）
 */
public interface Repository<TEntity extends AggregateRoot> {

    /**
     * 获取仓储上下文信息
     */
    RepositoryContext getContext();

    /**
     * 添加实体
     */
    void add(TEntity item) throws EerigoRepositoryConcurrentModificationException;

    /**
     * 删除实体
     */
    void remove(TEntity item) throws EerigoRepositoryConcurrentModificationException;

    /**
     * 更新实体
     */
    void update(TEntity item) throws EerigoRepositoryConcurrentModificationException;

    /**
     * 根据实体唯一标识获取实体
     */
    TEntity find(String id);

    /**
     * 获取总实体数
     * */
    int count();

    /**
     * 获取所有实体
     */
    List<TEntity> findAll();
}