package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:18 PM
 */
public class CategoryDTO extends BaseDTO {
    private String id;
    private String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
