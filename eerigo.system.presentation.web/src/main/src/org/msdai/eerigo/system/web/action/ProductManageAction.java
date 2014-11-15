package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.system.servicefacade.query.ProductQueryServiceFacade;
import org.msdai.eerigo.system.web.model.ProductModel;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductManageAction extends BaseAction {
    private ProductQueryServiceFacade productQueryServiceFacade = new ProductQueryServiceFacade();

    private List<ProductModel> models;

    public List<ProductModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {
        PageResultDTO<List<ProductDTO>> result = productQueryServiceFacade.queryProducts(0, 20);

        //transfer
        return SUCCESS;
    }
}
