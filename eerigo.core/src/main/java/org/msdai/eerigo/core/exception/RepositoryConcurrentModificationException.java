package org.msdai.eerigo.core.exception;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 22:37
 */
public class RepositoryConcurrentModificationException extends EerigoException {
    public RepositoryConcurrentModificationException(String message) {
        super(message);
    }
}
