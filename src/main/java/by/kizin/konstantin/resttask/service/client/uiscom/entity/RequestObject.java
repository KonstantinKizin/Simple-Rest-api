package by.kizin.konstantin.resttask.service.client.uiscom.entity;

import java.util.Map;

public class RequestObject {

    private Methods method;

    private Map<String,Object> params;

    public String getMethod() {
        return method.getValue();
    }

    public void setMethod(Methods method) {
        this.method = method;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
