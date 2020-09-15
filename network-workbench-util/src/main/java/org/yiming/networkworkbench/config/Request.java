package org.yiming.networkworkbench.config;

import java.util.HashMap;
import java.util.Map;

/**
 *  TODO 暂时放这里
 *  请求
 */
public class Request {

    private Map<String,String[]> requestParameterMap = new HashMap<>();

    public Map<String, String[]> getRequestParameterMap() {
        return requestParameterMap;
    }

    public void setRequestParameterMap(Map<String, String[]> requestParameterMap) {
        this.requestParameterMap = requestParameterMap;
    }

    public String[] getgetRequestParameter(String parameterName){
        return this.requestParameterMap.get(parameterName);
    }

}
