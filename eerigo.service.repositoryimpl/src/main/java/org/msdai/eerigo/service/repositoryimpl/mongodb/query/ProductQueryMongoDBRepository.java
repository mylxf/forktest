package org.msdai.eerigo.service.repositoryimpl.mongodb.query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import org.msdai.eerigo.core.exception.EerigoException;
import org.msdai.eerigo.service.query.repository.ProductQueryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductQueryMongoDBRepository extends MongoDBQueryRepository implements ProductQueryRepository {
    private static final String ProductCollection = "product";

    DBCollection productCollection;

    public ProductQueryMongoDBRepository(String mongoHost, int mongoPort, String mongoDatabase) throws EerigoException {
        super(mongoHost, mongoPort, mongoDatabase, false, null, null);
    }

    @Override
    public void initializeCollection() {
        if (!db.collectionExists(ProductCollection)) {
            productCollection = db.getCollection(ProductCollection);
            productCollection.createIndex(new BasicDBObject("productName", 1));
        } else {
            productCollection = db.getCollection(ProductCollection);
        }
    }

    @Override
    public PageResultDTO<List<ProductDTO>> queryProducts(ProductQueryRequestMessage productQueryRequestMessage) {
        return null;
    }
}
