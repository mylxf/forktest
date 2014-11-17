package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.system.servicefacade.action.CountryServiceFacade;
import org.msdai.eerigo.system.web.model.CountryModel;

import java.util.List;

/**
 * Created by fengfeng on 14/11/16.
 */
public class CountryManageAction extends BasePageAction {
    private CountryServiceFacade countryServiceFacade = new CountryServiceFacade();

    private List<CountryModel> models;

    public List<CountryModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {
        PageResultDTO<List<CountryDTO>> result = countryServiceFacade.getCountries();

        return SUCCESS;
    }

    public String addCountryView() throws Exception {
        return "addCountryView";
    }

    public String modifyCountryView() throws Exception{
        return "modifyCountryView";
    }
}
