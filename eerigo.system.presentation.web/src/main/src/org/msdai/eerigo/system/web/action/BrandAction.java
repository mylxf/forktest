package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;

import org.msdai.eerigo.system.web.model.BrandModel;

import org.msdai.eerigo.system.servicefacade.action.BrandServiceFacade;

import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:44
 */
public class BrandAction extends BaseAction {
    BrandServiceFacade brandServiceFacade = new BrandServiceFacade();

    private BrandModel model = new BrandModel();

    public BrandModel getModel() {
        return model;
    }

    @Override
    public String doExecute() throws Exception {
        return SUCCESS;
    }

    public String openView() throws Exception {
        String id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            BrandDTO brandDTO = brandServiceFacade.getBrand(id);
            model.setId(brandDTO.getId());
            model.setBrandName(brandDTO.getBrandName());
        }
        return "openView";
    }

    public String saveBrand() throws Exception {
        BrandDTO brand = new BrandDTO();
        brand.setId(model.getId());
        brand.setBrandName(model.getBrandName());
        try {
            if (StringUtils.isEmpty(brand.getId())) {
                brandServiceFacade.addBrand(brand);
            } else {
                brandServiceFacade.modifyBrand(brand);
            }
            setAlertMsg("品牌保存成功");
        } catch (Exception e) {
            setAlertMsg("品牌保存失败");
        }
        return SHOWALERT;
    }

    public String deleteBrand() throws Exception {
        try {
            String id = request.getParameter("id");
            brandServiceFacade.removeBrand(id);
            setAlertMsg("品牌删除成功");
        } catch (Exception e) {
            setAlertMsg("品牌删除失败");
        }
        return SHOWALERT;
    }
}
