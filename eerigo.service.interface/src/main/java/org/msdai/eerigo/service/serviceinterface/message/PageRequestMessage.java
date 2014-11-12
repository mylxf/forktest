package org.msdai.eerigo.service.serviceinterface.message;

import org.msdai.eerigo.core.service.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 1:01
 */
public class PageRequestMessage extends BaseDTO {
    private Integer index;
    private Integer size;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
