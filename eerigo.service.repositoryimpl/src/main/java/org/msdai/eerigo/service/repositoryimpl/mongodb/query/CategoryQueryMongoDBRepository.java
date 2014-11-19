package org.msdai.eerigo.service.repositoryimpl.mongodb.query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoException;
import org.msdai.eerigo.service.query.repository.CategoryQueryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CategoryQueryMongoDBRepository extends MongoDBQueryRepository implements CategoryQueryRepository {
    private static final String CategoryCollection = "category";

    DBCollection categoryCollection;

    public CategoryQueryMongoDBRepository(String mongoHost, int mongoPort, String mongoDatabase) throws EerigoException {
        super(mongoHost, mongoPort, mongoDatabase, false, null, null);
    }

    @Override
    public void initializeCollection() {
        if (!db.collectionExists(CategoryCollection)) {
            categoryCollection = db.getCollection(CategoryCollection);
            categoryCollection.createIndex(new BasicDBObject("categoryName", 1));
        } else {
            categoryCollection = db.getCollection(CategoryCollection);
        }
    }

    @Override
    public PagedResult<CategoryDTO> queryCategories(CategoryQueryRequestMessage categoryQueryRequestMessage) {
        return null;
    }


}
