package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.system.servicefacade.query.CategoryQueryServiceFacade;
import org.msdai.eerigo.system.web.model.CategoryModel;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CategoryManageAction extends BaseAction {
    private CategoryQueryServiceFacade categoryQueryServiceFacade = new CategoryQueryServiceFacade();

    private List<CategoryModel> models;

    public List<CategoryModel> getModels() {
        return models;
    }

    @Override
    public String doExecute() throws Exception {
        PageResultDTO<List<CategoryDTO>> result = categoryQueryServiceFacade.queryCategories(0, 20);

        //transfer
        return SUCCESS;
    }
}
