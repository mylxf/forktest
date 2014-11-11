package org.msdai.eerigo.core.service;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:18
 */
public class ServiceContext {
    protected static ThreadLocal<String> currentUserName;

    public static String getCurrentUserName() {
        return currentUserName.get();
    }
}
