package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

import java.util.List;

/**
 * Created by fengfeng on 14/11/25.
 */
public class MenuCategoryDTO extends BaseDTO {
    private String menuName;
    private List<String> categoryList;

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getCategoryList() {
        return this.categoryList;
    }
}
