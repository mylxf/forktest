package org.msdai.eerigo.core.service;

import org.msdai.eerigo.core.utils.EncryptUtils;

import org.msdai.eerigo.core.exception.EerigoException;

import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import org.apache.cxf.message.Message;

import org.apache.cxf.interceptor.Fault;

import org.springframework.util.StringUtils;

import java.util.TreeMap;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:18
 */
public class ServiceRequestInterceptor extends AbstractPhaseInterceptor {

    public ServiceRequestInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        try {
            boolean check = false;
            Object headers = message.get("org.apache.cxf.message.Message.PROTOCOL_HEADERS");
            TreeMap<String, ArrayList<String>> headerMap = (TreeMap<String, ArrayList<String>>) headers;
            String userName = headerMap.get("x-user-acct").get(0);
            String timezone = headerMap.get("x-portal-timezone").get(0);
            String key = headerMap.get("x-portal-publickey").get(0);
            String sign = headerMap.get("x-portal-sign").get(0);
            if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(key) && !StringUtils.isEmpty(timezone) && !StringUtils.isEmpty(sign)) {
                String newTimeZone = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
                String newSign = EncryptUtils.md5Encrypt(userName + timezone + key, key);
                if (newSign.equals(sign) && key.length() == 12 && timezone.equals(newTimeZone)) {
                    int pu = Integer.valueOf(key.substring(1, 2));
                    String privateKey = "$9$r1smc0e1$";
                    int pr = Integer.valueOf(privateKey.substring(1, 2));
                    if (pu + pr == 10) {
                        check = true;
                        new InternalServiceContext().setUserName(userName);
                    }
                }
            }
            if (!check) {
                throw new Fault(new EerigoException("application server authorized error"));
            }
        } catch (Exception exception) {
            throw new Fault(new EerigoException("application server authorized error"));
        }
    }
}

class InternalServiceContext extends ServiceContext {
    public void setUserName(String userName) {
        if (currentUserName == null) {
            currentUserName = new ThreadLocal<String>();
        }
        currentUserName.set(userName);
    }
}
