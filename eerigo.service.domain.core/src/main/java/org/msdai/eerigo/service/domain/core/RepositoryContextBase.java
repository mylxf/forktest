package org.msdai.eerigo.service.domain.core;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 4/1/14
 * Time: 3:24 PM
 */
public abstract class RepositoryContextBase implements RepositoryContext {

    private final ThreadLocal<Boolean> committed = new ThreadLocal<Boolean>();

    @Override
    public boolean isCommitted() {
        return committed.get();
    }

    protected void setCommitted(boolean committed) {
        this.committed.set(committed);
    }
}