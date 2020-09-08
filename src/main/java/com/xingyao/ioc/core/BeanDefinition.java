package com.xingyao.ioc.core;

/**
 * @Author ranger
 * @Date 2020/9/6 16:32
 **/
public class BeanDefinition {

    private String name;

    private String beanClass;

    private Class classType;

    private PropertyValues propertyValues;

    public BeanDefinition() {
    }

    public BeanDefinition(String name) {
        this.name = name;
    }

    public BeanDefinition(String name, String beanClass) {
        this.name = name;
        this.beanClass = beanClass;
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
