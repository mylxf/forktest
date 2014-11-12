package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.system.servicefacade.action.BrandServiceFacade;
import org.msdai.eerigo.system.web.model.BrandModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:45
 */
public class BrandManageAction extends BasePageAction {

    private BrandServiceFacade brandServiceFacade = new BrandServiceFacade();

    private List<BrandModel> models;

    public List<BrandModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {
        PageResultDTO<BrandDTO> result = brandServiceFacade.queryBrands(0, 20);
        //transfer
        return "index";
    }
}
