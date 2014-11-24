package org.msdai.eerigo.service.domain.model.country;

import org.msdai.eerigo.service.domain.core.AggregateRootBase;
import org.msdai.eerigo.service.domain.model.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 23:04
 * 国家
 */
public class Country extends AggregateRootBase{
    private String countryName;
    //private Resource countryFlag;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /*
    public Resource getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(Resource countryFlag) {
        this.countryFlag = countryFlag;
    }*/
}
