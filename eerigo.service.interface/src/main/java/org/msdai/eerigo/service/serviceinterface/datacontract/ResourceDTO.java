package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

/**
 * Created by fengfeng on 14/11/12.
 */
public class ResourceDTO extends BaseDTO {
    private String id;
    private String resourceUrl;
    private byte[] resourceContent;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
