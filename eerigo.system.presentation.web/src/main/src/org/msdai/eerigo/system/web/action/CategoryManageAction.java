package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.system.servicefacade.query.CategoryQueryServiceFacade;
import org.msdai.eerigo.system.web.model.CategoryModel;

import java.util.ArrayList;
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
        PagedResult<CategoryDTO> result = categoryQueryServiceFacade.queryCategories(0, 20);

        models = new ArrayList<CategoryModel>();
        for (CategoryDTO categoryDTO : result.getData()) {
            models.add(ConvertUtils.convert(categoryDTO, CategoryModel.class));
        }

        return SUCCESS;
    }

    public String addCategoryView() throws Exception {
        return "addCategoryView";
    }
}
