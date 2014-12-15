package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

/**
 * Created by fengfeng on 14/11/12.
 */
public class BrandDTO extends BaseDTO {
    private String id;
    private String brandName;
    private ResourceDTO resource;

    public BrandDTO() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ResourceDTO getResource() {
        return this.resource;
    }

    public void setResource(ResourceDTO resource) {
        this.resource = resource;
    }
}
