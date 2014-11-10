package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.category.Category;

import org.msdai.eerigo.service.domain.repository.CategoryRepository;

import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 0:00
 */
public class CategoryMongoDBRepository extends MongoDBRepository<Category> implements CategoryRepository {
    public CategoryMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Category find(String id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
