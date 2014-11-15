package org.msdai.eerigo.service.repositoryimpl.mongodb;

import com.mongodb.*;
import org.msdai.eerigo.service.domain.model.brand.Brand;

import org.msdai.eerigo.service.domain.repository.BrandRepository;

import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 0:01
 */
public class BrandMongoDBRepository extends MongoDBRepository<Brand> implements BrandRepository {
    private static final String BrandCollection = "brand";

    DBCollection brandCollection;

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
    public void insert(Brand brand){
        DBObject query = new BasicDBObject();
        query.put("id", brand.getId());
        DBCursor proxyCursor = brandCollection.find(query);

        if(!proxyCursor.hasNext()){
            BasicDBObject dbObject = new BasicDBObject();

            dbObject.append("id", brand.getId());
            dbObject.append("brand_name", brand.getBrandName());
            dbObject.append("brand_logo_id", null);

            brandCollection.insert(dbObject, WriteConcern.ACKNOWLEDGED);
        }
    }

    @Override
    public void update(Brand brand){
        DBObject query = new BasicDBObject();
        query.put("id", brand.getId());
        DBObject update = new BasicDBObject();
        update.put("brand_name", brand.getBrandName());
        update.put("brand_logo_id", null);

        brandCollection.update(query, new BasicDBObject("$set", update), false, false, WriteConcern.ACKNOWLEDGED);
    }

    @Override
    public void delete(Brand brand){
        DBObject query = new BasicDBObject();
        query.put("id", brand.getId());

        brandCollection.remove(query);
    }
}
