package org.msdai.eerigo.service.repositoryimpl.mongodb.query;

import com.mongodb.*;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoException;
import org.msdai.eerigo.service.query.repository.CategoryQueryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;

import java.util.ArrayList;
import java.util.List;

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
        int index = categoryQueryRequestMessage.getIndex();
        int size = categoryQueryRequestMessage.getSize();
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();

        QueryBuilder queryBuilder = QueryBuilder.start();
        DBObject query = queryBuilder.get();
        int count = (int)categoryCollection.count(query);
        int totalPage = (count%size == 0) ? count/size : count/size + 1;
        if (count > 0) {
            DBCursor cursor = categoryCollection.find(query).skip(index * size).limit(size);
            while (cursor.hasNext()) {
                list.add(transferCategoryDTO(cursor.next()));
            }
        }

        return new PagedResult<CategoryDTO>(count, totalPage, size, index, list);
    }

    private CategoryDTO transferCategoryDTO(DBObject object) {
        if (object == null) {
            return null;
        }
        String id = String.valueOf(object.get("_id"));
        String name = String.valueOf(object.get("categoryName"));
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(id);
        categoryDTO.setCategoryName(name);
        return categoryDTO;
    }

}
