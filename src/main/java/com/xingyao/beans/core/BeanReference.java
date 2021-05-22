package com.xingyao.ioc.core;

/**
 * @Author ranger
 * @Date 2020/9/6 21:44
 * 引用类型
 **/
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name, Object bean) {
        this.name = name;
        this.bean = bean;
    }

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
