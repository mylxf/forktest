package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.domain.model.product.Product;

import org.msdai.eerigo.service.domain.repository.ProductRepository;

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
 * Time: 0:01
 */
public class ProductMongoDBRepository extends MongoDBRepository<Product> implements ProductRepository {
    public ProductMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Product find(String id) {
        return this.getMongoDBRepositoryContext().getDB().findById(id, Product.class);
    }

    @Override
    public int count() {
        return Long.valueOf(this.getMongoDBRepositoryContext().getDB().count(new Query(), Product.class)).intValue();
    }

    @Override
    public List<Product> findAll() {
        return this.getMongoDBRepositoryContext().getDB().findAll(Product.class);
    }
}
