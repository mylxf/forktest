package org.msdai.eerigo.service.repositoryimpl;

import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/4/14
 * Time: 10:57 AM
 */
public interface MongoDBRepositoryContextSettings {
    MongoOperations getDB();
}
