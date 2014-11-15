package org.msdai.eerigo.service.repositoryimpl.mongodb;

import com.mongodb.DBCollection;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.domain.model.category.Category;

import org.msdai.eerigo.service.domain.repository.CategoryRepository;

import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 0:00
 */
public class CategoryMongoDBRepository extends MongoDBRepository<Category> implements CategoryRepository {

    private static final String CategoryCollection = "category";

    public CategoryMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Category find(String id) {
        return this.getMongoDBRepositoryContext().getDB().findById(id, Category.class);
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public void insert(Category category) {
        this.getMongoDBRepositoryContext().getDB().insert(category, CategoryCollection);
    }

    @Override
    public void update(Category category) {
        this.getMongoDBRepositoryContext().getDB().upsert(
                new Query(Criteria.where("id").is(category.getId())),
                new Update()
                        .addToSet("categoryname", category.getCategoryName()),
                CategoryCollection
        );
    }

    @Override
    public void delete(Category category) {
        this.getMongoDBRepositoryContext().getDB().remove(category, CategoryCollection);
    }
}
