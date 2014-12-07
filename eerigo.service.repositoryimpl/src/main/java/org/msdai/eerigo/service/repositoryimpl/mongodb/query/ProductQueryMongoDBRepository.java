package org.msdai.eerigo.service.repositoryimpl.mongodb.query;

import com.mongodb.*;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoException;
import org.msdai.eerigo.service.query.repository.ProductQueryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.DimensionsDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;

import java.util.ArrayList;
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
    public PagedResult<ProductDTO> queryProducts(ProductQueryRequestMessage productQueryRequestMessage) {
        int index = productQueryRequestMessage.getIndex();
        int size = productQueryRequestMessage.getSize();
        List<ProductDTO> list = new ArrayList<ProductDTO>();

        QueryBuilder queryBuilder = QueryBuilder.start();
        DBObject query = queryBuilder.get();
        int count = (int)productCollection.count(query);
        int totalPage = (count%size == 0) ? count/size : count/size + 1;
        if (count > 0) {
            DBCursor cursor = productCollection.find(query).skip(index * size).limit(size);
            while (cursor.hasNext()) {
                list.add(transferCategoryDTO(cursor.next()));
            }
        }

        return new PagedResult<ProductDTO>(count, totalPage, size, index, list);

    }

    private ProductDTO transferCategoryDTO(DBObject object) {
        if (object == null) {
            return null;
        }
        String id = String.valueOf(object.get("_id"));
        String name = String.valueOf(object.get("productName"));
        String productCategoryId = String.valueOf(object.get("productCategoryId"));
        String productBrandId = String.valueOf(object.get("productBrandId"));
        String countryId = String.valueOf(object.get("countryId"));
        String productDesc = String.valueOf(object.get("productDesc"));
        Double costPrice = Double.valueOf(object.get("costPrice").toString());
        Double sellPrice = Double.valueOf(object.get("sellPrice").toString());
        DimensionsDTO productDimensions = new DimensionsDTO();
        Double weight = Double.valueOf(object.get("weight").toString());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setProductName(name);
        productDTO.setProductCategoryId(productCategoryId);
        productDTO.setProductBrandId(productBrandId);
        productDTO.setCountryId(countryId);
        productDTO.setProductDesc(productDesc);
        productDTO.setCostPrice(costPrice);
        productDTO.setSellPrice(sellPrice);
        productDTO.setProductDimensions(productDimensions);
        productDTO.setWeight(weight);

        return productDTO;
    }
}
