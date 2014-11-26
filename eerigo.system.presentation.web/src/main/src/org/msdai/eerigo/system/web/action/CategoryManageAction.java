package org.msdai.eerigo.system.web.action;

import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.system.servicefacade.query.CategoryQueryServiceFacade;
import org.msdai.eerigo.system.web.model.CategoryModel;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CategoryManageAction extends BaseAction {
    private CategoryQueryServiceFacade categoryQueryServiceFacade = new CategoryQueryServiceFacade();

    private List<CategoryModel> models;
    private Integer index;
    private Integer preIndex;
    private Integer nextIndex;
    private Integer lastIndex;

    public List<CategoryModel> getModels() {
        return models;
    }

    public Integer getIndex() {
        return this.index;
    }

    public Integer getPreIndex() {
        return preIndex;
    }

    public Integer getNextIndex() {
        return nextIndex;
    }

    public Integer getLastIndex() {
        return lastIndex;
    }

    @Override
    public String doExecute() throws Exception {
        if (request.getParameter("index") != null)
            index = Integer.valueOf(request.getParameter("index"));
        else
            index = 1;

        PagedResult pagedResult = categoryQueryServiceFacade.queryCategories(index, 1);

        models = (List<CategoryModel>) pagedResult.getData();

        preIndex = (index <= 1) ? 1 : index - 1;
        //nextIndex = (index < pagedResult.getTotalPages()) ? index + 1 : pagedResult.getTotalPages();
        nextIndex = index + 1;
        lastIndex = pagedResult.getTotalPages();

        return SUCCESS;
    }
}
