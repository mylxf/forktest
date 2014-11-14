package org.msdai.eerigo.service.domain.model.brand;

import org.msdai.eerigo.service.domain.model.Resource;

import org.msdai.eerigo.service.domain.core.AggregateRootBase;


/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 22:40
 * 品牌
 */
public class Brand extends AggregateRootBase {
    /**
     * 品牌名称
     */
    private String brandName;
    private Resource brandLogo;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Resource getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(Resource brandLogo) {
        this.brandLogo = brandLogo;
    }
}
