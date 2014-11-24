package org.msdai.eerigo.core;

/**
 * Created by fengfeng on 14/11/24.
 */
public class OperatorResult {
    private Boolean result;

    public OperatorResult(Boolean result){
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public void setResult(Boolean value) {
        this.result = value;
    }
}
