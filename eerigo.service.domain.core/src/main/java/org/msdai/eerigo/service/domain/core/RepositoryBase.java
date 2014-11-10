package org.msdai.eerigo.service.domain.core;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/1/14
 * Time: 4:06 PM
 */
public abstract class RepositoryBase implements Repository {

    private final RepositoryContext context;

    public RepositoryBase(RepositoryContext context) {
        this.context = context;
    }
}
