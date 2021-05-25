package com.xingyao.beans.core;

import java.util.ArrayList;

/**
 * @Author ranger
 * @Date 2020/9/6 16:32
 **/
public class BeanDefinition {

    /**
     * bean的名字
     */
    private String name;

    /**
     * Class的全路径
     */
    private String beanClass;

    /**
     * Class 对象
     */
    private Class classType;

    /**
     * bean的属性
     */
    private PropertyValues propertyValues;

    public BeanDefinition() {
    }

    public BeanDefinition(String name) {
        this.name = name;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(String name, String beanClass) {
        this.name = name;
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(String name, String beanClass, PropertyValues propertyValues) {
        this.name = name;
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) throws ClassNotFoundException {
        this.beanClass = beanClass;
        try{
            Class clazz = Class.forName(beanClass);
            this.classType = clazz;
        }catch (ClassNotFoundException e){
            throw e;
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }
}
