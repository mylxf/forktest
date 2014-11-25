package org.msdai.eerigo.service.domain.model.category;

import org.msdai.eerigo.service.domain.core.AggregateRootBase;

import java.util.List;

/**
 * Created by fengfeng on 14/11/25.
 */
public class MenuCategory extends AggregateRootBase {
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
