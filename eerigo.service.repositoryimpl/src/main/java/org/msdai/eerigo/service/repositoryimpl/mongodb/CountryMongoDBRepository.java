package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.country.Country;
import org.msdai.eerigo.service.domain.repository.CountryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:08 PM
 */
public class CountryMongoDBRepository extends MongoDBRepository<Country> implements CountryRepository {
    public CountryMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Country find(String id) {
        return this.getMongoDBRepositoryContext().getDB().findById(id, Country.class);
    }

    @Override
    public int count() {
        return Long.valueOf(this.getMongoDBRepositoryContext().getDB().count(new Query(), Country.class)).intValue();
    }

    @Override
    public List<Country> findAll() {
        return this.getMongoDBRepositoryContext().getDB().findAll(Country.class);
    }
}
