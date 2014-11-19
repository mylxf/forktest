package org.msdai.eerigo.service.repositoryimpl.mongodb.query;

import org.msdai.eerigo.core.PagedResult;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

import org.msdai.eerigo.service.query.repository.BrandQueryRepository;

import org.msdai.eerigo.service.repositoryimpl.MongoDBQueryRepository;

import org.msdai.eerigo.core.exception.EerigoException;

import com.mongodb.*;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/14/2014
 * Time: 11:34 AM
 */
public class BrandQueryMongoDBRepository extends MongoDBQueryRepository implements BrandQueryRepository {

    private static final String BrandCollection = "brand";

    DBCollection brandCollection;

    public BrandQueryMongoDBRepository(String mongoHost, int mongoPort, String mongoDatabase) throws EerigoException {
        super(mongoHost, mongoPort, mongoDatabase, false, null, null);
    }

    @Override
    public void initializeCollection() {
        if (!db.collectionExists(BrandCollection)) {
            brandCollection = db.getCollection(BrandCollection);
            brandCollection.createIndex(new BasicDBObject("brandName", 1));
        } else {
            brandCollection = db.getCollection(BrandCollection);
        }
    }

    @Override
    public PagedResult<BrandDTO> queryBrands(BrandQueryRequestMessage brandQueryRequestMessage) {
        int index = brandQueryRequestMessage.getIndex();
        int size = brandQueryRequestMessage.getSize();
        PagedResult<BrandDTO> result = new PagedResult<BrandDTO>();
        QueryBuilder queryBuilder = QueryBuilder.start();
        DBObject query = queryBuilder.get();
        long count = brandCollection.count(query);
        if (count > 0) {
            DBCursor cursor = brandCollection.find(query).skip(index * size).limit(size);
            while (cursor.hasNext()) {
                result.add(transferBrandDTO(cursor.next()));
            }
        }
        return result;
    }

    private BrandDTO transferBrandDTO(DBObject object) {
        if (object == null) {
            return null;
        }
        String id = String.valueOf(object.get("_id"));
        String name = String.valueOf(object.get("brandName"));
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(id);
        brandDTO.setBrandName(name);
        return brandDTO;
    }
}
