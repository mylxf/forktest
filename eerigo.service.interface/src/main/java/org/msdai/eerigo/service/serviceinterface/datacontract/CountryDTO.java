package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

/**
 * Created by fengfeng on 14/11/12.
 */
public class CountryDTO extends BaseDTO {
    private String id;
    private String countryName;
    //private ResourceDTO countryFlag;

    public CountryDTO() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /*
    public ResourceDTO getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(ResourceDTO countryFlag) {
        this.countryFlag = countryFlag;
    }*/
}
