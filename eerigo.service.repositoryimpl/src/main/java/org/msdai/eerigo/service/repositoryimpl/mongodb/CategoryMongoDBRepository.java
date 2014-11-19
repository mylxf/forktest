package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.category.Category;
import org.msdai.eerigo.service.domain.repository.CategoryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;
import org.springframework.data.mongodb.core.query.Query;

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
        return this.getMongoDBRepositoryContext().getDB().findById(id, Category.class);
    }

    @Override
    public int count() {
        return Long.valueOf(this.getMongoDBRepositoryContext().getDB().count(new Query(), Category.class)).intValue();
    }

    @Override
    public List<Category> findAll() {
        return this.getMongoDBRepositoryContext().getDB().findAll(Category.class);
    }
}
