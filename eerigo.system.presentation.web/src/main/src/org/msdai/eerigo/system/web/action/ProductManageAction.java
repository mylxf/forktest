package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.system.servicefacade.query.ProductQueryServiceFacade;
import org.msdai.eerigo.system.web.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductManageAction extends BaseAction {
    private ProductQueryServiceFacade productQueryServiceFacade = new ProductQueryServiceFacade();

    private List<ProductModel> models = new ArrayList<ProductModel>();

    public List<ProductModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {
        models = productQueryServiceFacade.queryProducts(0, 20).getData();

        //transfer
        return SUCCESS;
    }
}
