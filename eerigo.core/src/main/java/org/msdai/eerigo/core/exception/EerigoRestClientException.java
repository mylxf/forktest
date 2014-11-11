package org.msdai.eerigo.core.exception;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:28
 */
public class EerigoRestClientException extends EerigoException {
    private String message;

    public EerigoRestClientException(Throwable cause) {
        super(cause);
    }

    public EerigoRestClientException(String requestUrl, int status, String exceptionMessage) {
        this.message = "call service " + requestUrl + " failed .\r\n" + "status : " + status + "\r\n" + "error detail : " + exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
