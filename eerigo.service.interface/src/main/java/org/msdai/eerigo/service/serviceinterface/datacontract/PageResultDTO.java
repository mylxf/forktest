package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:22 PM
 */
@XmlSeeAlso({BrandDTO.class, ArrayList.class})
public class PageResultDTO<T> extends BaseDTO {
    private int count;

    private T result;

    public PageResultDTO(int count, T result) {
        this.count = count;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
