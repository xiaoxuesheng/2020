package com.hjj.toy.util.bean;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;

import java.util.Map;

/**
*
*/
public class DynamicBeanFactory {



    //通过apache common 包 可以动态生成简单的bean，只带属性

    public static DynaBean createBeanApacheCommon(String beanName,Map<String,Class> attr) throws InstantiationException, IllegalAccessException {

        DynaProperty[] dynaProperties = new DynaProperty[]{};
        int i = 0;
        for(String key:attr.keySet()){
            DynaProperty property = new DynaProperty(key,attr.get(key));
            dynaProperties[i] = property;
            i++;
        }
        BasicDynaClass basicDynaClass = new BasicDynaClass(beanName, BasicDynaBean.class, dynaProperties);
        DynaBean basicDynaBean = basicDynaClass.newInstance();

        return basicDynaBean;
    }



    public static DynaBean createBeanCglib(String beanName,Map<String,Class> attr) throws InstantiationException, IllegalAccessException {

        DynaProperty[] dynaProperties = new DynaProperty[]{};
        int i = 0;
        for(String key:attr.keySet()){
            DynaProperty property = new DynaProperty(key,attr.get(key));
            dynaProperties[i] = property;
            i++;
        }
        BasicDynaClass basicDynaClass = new BasicDynaClass(beanName, BasicDynaBean.class, dynaProperties);
        DynaBean basicDynaBean = basicDynaClass.newInstance();

        return basicDynaBean;
    }




}
