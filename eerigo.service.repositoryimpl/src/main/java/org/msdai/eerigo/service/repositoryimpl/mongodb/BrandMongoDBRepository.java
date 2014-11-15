package org.msdai.eerigo.service.repositoryimpl.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.domain.repository.BrandRepository;
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
public class BrandMongoDBRepository extends MongoDBRepository<Brand> implements BrandRepository {
    private static final String BrandCollection = "brand";

    public BrandMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Brand find(String id) {
        return this.getMongoDBRepositoryContext().getDB().findById(id, Brand.class);
    }

    @Override
    public int count() {
        return Long.valueOf(this.getMongoDBRepositoryContext().getDB().count(new Query(), Brand.class)).intValue();
    }

    @Override
    public List<Brand> findAll() {
        return this.getMongoDBRepositoryContext().getDB().findAll(Brand.class);
    }

    @Override
    public void insert(Brand brand) {
        this.getMongoDBRepositoryContext().getDB().insert(brand, BrandCollection);
    }

    @Override
    public void update(Brand brand) {
        this.getMongoDBRepositoryContext().getDB().upsert(
                new Query(Criteria.where("id").is(brand.getId())),
                new Update()
                        .addToSet("brandname", brand.getBrandName())
                        .addToSet("brandlogo", null),
                BrandCollection
        );
    }

    @Override
    public void delete(Brand brand) {
        this.getMongoDBRepositoryContext().getDB().remove(brand, BrandCollection);
    }
}
