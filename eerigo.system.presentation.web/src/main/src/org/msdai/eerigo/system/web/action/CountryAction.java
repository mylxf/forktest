package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.system.servicefacade.action.CountryServiceFacade;
import org.msdai.eerigo.system.web.model.CountryModel;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/17.
 */
public class CountryAction extends BasePageAction {
    private CountryServiceFacade countryServiceFacade = new CountryServiceFacade();

    private CountryModel model = new CountryModel();

    public CountryModel getModel() {
        return this.model;
    }

    @Override
    public String doExecute() throws Exception {
        return SUCCESS;
    }

    public String openView() throws Exception {
        String id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            CountryDTO country = countryServiceFacade.getCountry(id);
            model = ConvertUtils.convert(country, CountryModel.class);
        }

        return "openView";
    }

    public String saveCountry() throws Exception {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(model.getId());
        countryDTO.setCountryName(model.getCountryName());
        try {
            if (StringUtils.isEmpty(countryDTO.getId())) {
                countryServiceFacade.addCountry(countryDTO);
            } else {
                countryServiceFacade.modifyCountry(countryDTO);
            }
            setAlertMsg("产地保存成功");
        } catch (Exception e) {
            setAlertMsg("产地保存失败");
        }
        return SHOWALERT;
    }

    public String deleteCountry() throws Exception {
        String id = request.getParameter("id");
        return (countryServiceFacade.removeCountry(id).getResult()) ? SUCCESS : ERROR;
    }

    public String batchDelCountry() throws Exception {
        String idList = request.getParameter("id_list");
        List<String> list = new ArrayList<String>();
        String[] strings = idList.split("\\|");

        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }

        return (countryServiceFacade.batchRemoveCountry(list).getResult()) ? SUCCESS : ERROR;
    }
}
