package org.msdai.eerigo.service.repositoryimpl;

import org.msdai.eerigo.core.exception.EerigoException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoOptions;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/14/2014
 * Time: 1:36 PM
 */
public abstract class MongoDBQueryRepository {
    protected MongoClient mongoClient;
    protected DB db;

    public MongoDBQueryRepository(String mongoHost, int mongoPort, String mongoDatabase, boolean auth, String mongoUser, String mongoPassword) throws EerigoException {
        try {
            if (mongoClient == null) {
                mongoClient = new MongoClient(mongoHost, mongoPort);
                MongoOptions options = mongoClient.getMongoOptions();
                options.setConnectionsPerHost(100);
            }
            if (db == null) {
                db = mongoClient.getDB(mongoDatabase);
            }
        } catch (Exception exception) {
            throw new EerigoException(new Throwable("mongodb repository initialize error"));
        }
        if (auth) {
            boolean r = db.authenticate(mongoUser, mongoPassword.toCharArray());
            if (!r) {
                throw new EerigoException(new Throwable("mongodb repository authenticate error"));
            }
        }
        initializeCollection();
    }

    public abstract void initializeCollection();
}