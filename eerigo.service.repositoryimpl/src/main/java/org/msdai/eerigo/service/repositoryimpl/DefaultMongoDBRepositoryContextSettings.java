package org.msdai.eerigo.service.repositoryimpl;

import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/4/14
 * Time: 2:02 PM
 */
public class DefaultMongoDBRepositoryContextSettings implements MongoDBRepositoryContextSettings {

    private MongoOperations mongoTemplate;

    public DefaultMongoDBRepositoryContextSettings(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public MongoOperations getDB() {
        return mongoTemplate;
    }
}