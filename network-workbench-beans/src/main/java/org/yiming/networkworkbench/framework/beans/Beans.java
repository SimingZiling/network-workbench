package org.yiming.networkworkbench.framework.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Beans {

    protected static List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();

    protected static Map<String,BeanDefinition> beanDefinitionMap = new HashMap<String,BeanDefinition>();

    public static Object getBean(String benaName){
        return beanDefinitionMap.get(benaName).getObject();
    }
}
