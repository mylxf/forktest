package org.msdai.eerigo.service.repositoryimpl;

import org.msdai.eerigo.service.domain.core.RepositoryContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/4/14
 * Time: 11:01 AM
 */
public interface MongoDBRepositoryContext extends RepositoryContext {
    MongoOperations getDB();
}
