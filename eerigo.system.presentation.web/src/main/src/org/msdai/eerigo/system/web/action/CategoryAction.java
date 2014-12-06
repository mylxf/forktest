package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BasePageAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.system.servicefacade.action.CategoryServiceFacade;
import org.msdai.eerigo.system.web.model.CategoryModel;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/18.
 */
public class CategoryAction extends BasePageAction {
    private CategoryServiceFacade categoryServiceFacade = new CategoryServiceFacade();

    private CategoryModel model = new CategoryModel();

    public CategoryModel getModel() {
        return this.model;
    }

    @Override
    public String doExecute() throws Exception {
        return SUCCESS;
    }

    public String openView() throws Exception {
        String id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            CategoryDTO country = categoryServiceFacade.getCategory(id);
            model = ConvertUtils.convert(country, CategoryModel.class);
        }

        return "openView";
    }

    public String saveCategory() throws Exception{
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(model.getId());
        categoryDTO.setCategoryName(model.getCategoryName());
        try {
            if (StringUtils.isEmpty(categoryDTO.getId())) {
                categoryServiceFacade.addCategory(categoryDTO);
            } else {
                categoryServiceFacade.modifyCategory(categoryDTO);
            }
            setAlertMsg("类别保存成功");
        } catch (Exception e) {
            setAlertMsg("类别保存失败");
        }
        return SHOWALERT;
    }

    public String deleteCategory() throws Exception {
        String id = request.getParameter("id");
        return (categoryServiceFacade.removeCategory(id).getResult()) ? SUCCESS : ERROR;
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
