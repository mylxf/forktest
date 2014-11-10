package org.msdai.eerigo.core.exception;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 22:38
 */
public class EerigoException extends Exception {
    public EerigoException() {
        super();
    }

    public EerigoException(String message) {
        super(message);
    }

    public EerigoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EerigoException(Throwable cause) {
        super(cause);
    }
}
