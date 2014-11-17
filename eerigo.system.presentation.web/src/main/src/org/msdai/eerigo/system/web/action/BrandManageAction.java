package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.system.servicefacade.query.BrandQueryServiceFacade;
import org.msdai.eerigo.system.web.model.BrandModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:45
 */
public class BrandManageAction extends BasePageAction {

    private BrandQueryServiceFacade brandQueryServiceFacade = new BrandQueryServiceFacade();

    private List<BrandModel> models;

    public List<BrandModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {
        PageResultDTO result = brandQueryServiceFacade.queryBrands(0, 20);
        for (BrandDTO brand : ((List<BrandDTO>) result.getResult())) {
            if (models == null) {
                models = new ArrayList<BrandModel>();
            }
            models.add(ConvertUtils.convert(brand, BrandModel.class));
        }
        return SUCCESS;
    }
}
