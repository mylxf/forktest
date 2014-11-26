package org.msdai.eerigo.service.domain.model.category;

import org.msdai.eerigo.service.domain.core.AggregateRootBase;

import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 22:40
 * 类别
 */
public class Category extends AggregateRootBase {
    /**
     * 类别名称
     */
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /*

    private List<Category> subcategories;

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public void addSubcategory(Category category) {
        if (subcategories == null) {
            subcategories = new ArrayList<Category>();
        }
        if (!subcategories.contains(category)) {
            subcategories.add(category);
        }
    }

    public void removeSubcategory(Category category) {
        if (subcategories == null) {
            subcategories = new ArrayList<Category>();
        }
        if (!subcategories.contains(category)) {
            subcategories.remove(category);
        }
    }
    */
}
