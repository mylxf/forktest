package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.system.servicefacade.action.BrandServiceFacade;
import org.msdai.eerigo.system.web.model.BrandModel;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:44
 */
public class BrandAction extends BaseAction {
    BrandServiceFacade brandServiceFacade = new BrandServiceFacade();

    private BrandModel model;

    public BrandModel getModel() {
        return model;
    }

    @Override
    public String doExecute() throws Exception {
        String id = request.getParameter("model.id");
        String brandName = request.getParameter("model.brandName");
        BrandDTO brand = new BrandDTO();
        brand.setId(id);
        brand.setBrandName(brandName);
        try {
            brandServiceFacade.addBrand(brand);
            setAlertMsg("品牌保存成功");
        } catch (Exception e) {
            setAlertMsg("品牌保存失败");
        }
        return "showAlert";
    }
}
