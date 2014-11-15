package org.msdai.eerigo.service.repositoryimpl.mongodb;

import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.domain.model.country.Country;
import org.msdai.eerigo.service.domain.repository.CountryRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepository;
import org.msdai.eerigo.service.repositoryimpl.MongoDBRepositoryContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:08 PM
 */
public class CountryMongoDBRepository extends MongoDBRepository<Country> implements CountryRepository {
    private static final String CountryCollection = "country";

    public CountryMongoDBRepository(MongoDBRepositoryContext mongoDBRepositoryContext) {
        super(mongoDBRepositoryContext);
    }

    @Override
    public Country find(String id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Country> findAll() {
        return null;
    }

    @Override
    public void insert(Country country) {
        this.getMongoDBRepositoryContext().getDB().insert(country, CountryCollection);
    }

    @Override
    public void update(Country country) {
        this.getMongoDBRepositoryContext().getDB().upsert(
                new Query(Criteria.where("id").is(country.getId())),
                new Update()
                        .addToSet("countryname", country.getCountryName())
                        .addToSet("countryflag", null),
                CountryCollection
        );
    }

    @Override
    public void delete(Country country) {
        this.getMongoDBRepositoryContext().getDB().remove(country, CountryCollection);
    }
}
