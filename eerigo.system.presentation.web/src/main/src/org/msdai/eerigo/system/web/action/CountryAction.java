package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.system.servicefacade.action.CountryServiceFacade;
import org.msdai.eerigo.system.web.model.CountryModel;

import java.util.List;

/**
 * Created by fengfeng on 14/11/17.
 */
public class CountryAction extends BasePageAction {
    private CountryServiceFacade countryServiceFacade = new CountryServiceFacade();

    private List<CountryModel> models;

    public List<CountryModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {

        return SUCCESS;
    }

    public String addCountry() throws Exception{
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryName(request.getParameter("countryName"));
        countryDTO.setCountryFlag(null);
        countryServiceFacade.addCountry(countryDTO);
        return SUCCESS;
    }

    public String modifyCountry() throws Exception{
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(request.getParameter("countryId"));
        countryDTO.setCountryName(request.getParameter("countryName"));
        countryDTO.setCountryFlag(null);
        countryServiceFacade.modifyCountry(countryDTO);
        return SUCCESS;
    }
}
