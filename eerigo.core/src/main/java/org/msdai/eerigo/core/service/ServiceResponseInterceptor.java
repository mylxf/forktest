package org.msdai.eerigo.core.service;

import org.msdai.eerigo.core.exception.EerigoException;

import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import org.apache.cxf.message.Message;

import org.apache.cxf.interceptor.Fault;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:18
 */
public class ServiceResponseInterceptor extends AbstractPhaseInterceptor {
    public ServiceResponseInterceptor() {
        super(Phase.PRE_PROTOCOL);
        addAfter(ServiceResponseInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        Fault oriFault = (Fault) message.getContent(Exception.class);
        message.setContent(EerigoException.class, oriFault);
    }
}
