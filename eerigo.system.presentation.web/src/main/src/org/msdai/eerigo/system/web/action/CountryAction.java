package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.system.servicefacade.action.CountryServiceFacade;
import org.msdai.eerigo.system.web.model.CountryModel;

/**
 * Created by fengfeng on 14/11/17.
 */
public class CountryAction extends BasePageAction {
    private CountryServiceFacade countryServiceFacade = new CountryServiceFacade();

    private CountryModel model;

    public CountryModel getModel() {
        return this.model;
    }

    @Override
    public String doExecute() throws Exception {
        String id = request.getParameter("id");
        if (id != null && id != "") {
            CountryDTO country = countryServiceFacade.getCountry(id);

            if (country != null) {
                model = ConvertUtils.convert(country, CountryModel.class);
            }
            method = "modifyCountry";
        } else {
            method = "addCountry";
        }

        return "optCountryView";
    }

    public String addCountry() throws Exception {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryName(request.getParameter("model.countryName"));
        //countryDTO.setCountryFlag(null);

        return (countryServiceFacade.addCountry(countryDTO).getResult()) ? SUCCESS : ERROR;
    }

    public String modifyCountry() throws Exception {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(request.getParameter("model.id"));
        countryDTO.setCountryName(request.getParameter("model.countryName"));
        //countryDTO.setCountryFlag(null);
        return (countryServiceFacade.modifyCountry(countryDTO).getResult()) ? SUCCESS : ERROR;
    }
}
