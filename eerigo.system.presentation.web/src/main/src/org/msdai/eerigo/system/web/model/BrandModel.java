package org.msdai.eerigo.system.web.model;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:55
 */
public class BrandModel {
    private String brandName;
    private ResourceModel brandLogo;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ResourceModel getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(ResourceModel brandLogo) {
        this.brandLogo = brandLogo;
    }
}
