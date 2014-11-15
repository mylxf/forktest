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
    private static final String ProductCollection = "product";

    public ProductMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Product find(String id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void insert(Product product) {
        this.getMongoDBRepositoryContext().getDB().insert(product, ProductCollection);
    }

    @Override
    public void update(Product product) {
        this.getMongoDBRepositoryContext().getDB().upsert(
                new Query(Criteria.where("id").is(product.getId())),
                new Update()
                    .addToSet("productname", product.getProductName())
                    .addToSet("productcategory", product.getProductCategory())
                    .addToSet("productbrand", product.getProductBrand())
                    .addToSet("origin", product.getOrigin())
                    .addToSet("productdesc", product.getProductDesc())
                    .addToSet("productimages", product.getProductImages())
                    .addToSet("costprice", product.getCostPrice())
                    .addToSet("sellprice", product.getSellPrice())
                    .addToSet("productDimensions", product.getProductDimensions())
                    .addToSet("weight", product.getWeight())
                    .addToSet("productProperties", product.getProductProperties()),
                ProductCollection
        );
    }

    @Override
    public void delete(Product product) {
        this.getMongoDBRepositoryContext().getDB().remove(product, ProductCollection);
    }
}
