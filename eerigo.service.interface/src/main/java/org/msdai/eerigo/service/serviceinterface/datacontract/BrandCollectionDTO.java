package org.msdai.eerigo.service.serviceinterface.datacontract;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/29
 * Time: 19:44
 */
public class BrandCollectionDTO {
    private List<BrandDTO> brands;

    public List<BrandDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandDTO> brands) {
        this.brands = brands;
    }
}
