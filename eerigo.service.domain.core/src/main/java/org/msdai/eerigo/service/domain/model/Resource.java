package org.msdai.eerigo.service.domain.model;

import org.msdai.eerigo.service.domain.core.AggregateRootBase;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 23:08
 */
public class Resource extends AggregateRootBase {
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
