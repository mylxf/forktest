package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.category.MenuCategory;
import org.msdai.eerigo.service.domain.repository.MenuCategoryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by fengfeng on 14/11/25.
 */
public class MenuCategoryMongoDBRepository extends MongoDBRepository<MenuCategory> implements MenuCategoryRepository {
    public MenuCategoryMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public MenuCategory find(String id) {
        return this.getMongoDBRepositoryContext().getDB().findById(id, MenuCategory.class);
    }

    @Override
    public int count() {
        return Long.valueOf(this.getMongoDBRepositoryContext().getDB().count(new Query(), MenuCategory.class)).intValue();
    }

    @Override
    public List<MenuCategory> findAll() {
        return this.getMongoDBRepositoryContext().getDB().findAll(MenuCategory.class);
    }
}
