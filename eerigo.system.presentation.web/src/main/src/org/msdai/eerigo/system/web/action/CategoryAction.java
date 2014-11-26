package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.system.servicefacade.action.CategoryServiceFacade;
import org.msdai.eerigo.system.web.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/18.
 */
public class CategoryAction extends BasePageAction {
    private CategoryServiceFacade categoryServiceFacade = new CategoryServiceFacade();

    private CategoryModel model;

    public CategoryModel getModel() {
        return this.model;
    }

    @Override
    public String doExecute() throws Exception {
        String id = request.getParameter("id");
        if (id != null && id != "") {
            CategoryDTO category = categoryServiceFacade.getCategory(id);

            if (category != null) {
                model = ConvertUtils.convert(category, CategoryModel.class);
            }
            method = "modifyCategory";
        } else {
            method = "addCategory";
        }

        return "optCategoryView";
    }

    public String addCategory() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(request.getParameter("model.categoryName"));
        return (categoryServiceFacade.addCategory(categoryDTO).getResult()) ? SUCCESS : ERROR;
    }

    public String modifyCategory() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(request.getParameter("model.id"));
        categoryDTO.setCategoryName(request.getParameter("model.categoryName"));
        return (categoryServiceFacade.modifyCategory(categoryDTO).getResult()) ? SUCCESS : ERROR;
    }

    public String batchDelCategory() throws Exception {
        String idList = request.getParameter("id_list");
        List<String> list = new ArrayList<String>();
        String[] strings = idList.split("\\|");

        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }

        return (categoryServiceFacade.batchRemoveCategory(list).getResult()) ? SUCCESS : ERROR;
    }
}
