package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.brand.Brand;

import org.msdai.eerigo.service.domain.repository.BrandRepository;

import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 0:01
 */
public class BrandMongoDBRepository extends MongoDBRepository<Brand> implements BrandRepository {
    public BrandMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Brand find(String id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Brand> findAll() {
        return null;
    }
}
