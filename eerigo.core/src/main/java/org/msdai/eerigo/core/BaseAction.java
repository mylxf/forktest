package org.msdai.eerigo.core;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:42
 */
public abstract class BaseAction extends ActionSupport implements SessionAware, ServletResponseAware {
    private static final long serialVersionUID = -4352837286961678277L;

    private int flag;
    private String alertMsg;
    protected String method = "";
    protected HttpServletRequest request = null;
    protected HttpServletResponse response = null;
    protected Map<String, Object> requestMap = null;
    protected Map<String, Object> sessionMap = null;
    protected Map<?, ?> session = null;
    protected Map<?, ?> application = null;

    abstract public String doExecute() throws Exception;

    public final String execute() throws Exception {
        String methodName = method.trim();
        String strFlagString = "";// 转发标志
        try {
            application = ServletActionContext.getContext().getApplication();
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();
            session = ServletActionContext.getContext().getSession();
            requestMap = ActionContext.getContext().getContextMap();
            sessionMap = ActionContext.getContext().getSession();
            Class cls = this.getClass();
            Method appMethod;
            if (method == null || "".equals(methodName)) {
                appMethod = cls.getMethod("doExecute");
            } else {
                appMethod = cls.getMethod(methodName);
            }
            strFlagString = (String) appMethod.invoke(this);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            strFlagString = ActionSupport.INPUT;
        } catch (NoSuchMethodException e) {
            strFlagString = ActionSupport.INPUT;
        } catch (Exception e) {
            strFlagString = ActionSupport.INPUT;
        }
        return strFlagString;
    }

    public void printOut(String str) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            response.setContentType("text/html");
            response.setContentType("application/json-rpc;charset=utf-8");
            response.setHeader("Cache-Control", "no-cache");
            PrintWriter pw = response.getWriter();
            pw.print(str);
            pw.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public void setRequest(HttpServletRequest requestObj) {
        ServletActionContext.setRequest(requestObj);
    }

    public void setResponse(HttpServletResponse responseObj) {
        ServletActionContext.setResponse(responseObj);
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        this.response = response;
    }

    public void setSession(Map<String, Object> session) {
        this.sessionMap = session;
    }

    public void setApplication(Map<String, Object> applicationObj) {
        ServletActionContext.getContext().setApplication(applicationObj);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
