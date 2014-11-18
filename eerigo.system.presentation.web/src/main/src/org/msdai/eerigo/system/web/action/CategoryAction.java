package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.system.servicefacade.action.CategoryServiceFacade;
import org.msdai.eerigo.system.web.model.CategoryModel;

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
            PageResultDTO<CategoryDTO> resultDTO = categoryServiceFacade.getCategory(id);

            if (resultDTO.getCount() == 1) {
                model = ConvertUtils.convert(resultDTO.getResult(), CategoryModel.class);
            }
        }

        return "optCountryView";
    }

    public String addCountry() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(request.getParameter("model.categoryName"));
        categoryServiceFacade.addCategory(categoryDTO);
        return SUCCESS;
    }

    public String modifyCountry() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(request.getParameter("model.id"));
        categoryDTO.setCategoryName(request.getParameter("model.categoryName"));
        categoryServiceFacade.modifyCategory(categoryDTO);
        return SUCCESS;
    }
}
