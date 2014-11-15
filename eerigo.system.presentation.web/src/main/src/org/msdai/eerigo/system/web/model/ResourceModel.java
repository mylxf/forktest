package org.msdai.eerigo.system.web.model;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ResourceModel {
    private String resourceUrl;
    private byte[] resourceContent;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public byte[] getResourceContent() {
        return resourceContent;
    }

    public void setResourceContent(byte[] resourceContent) {
        this.resourceContent = resourceContent;
    }
}
