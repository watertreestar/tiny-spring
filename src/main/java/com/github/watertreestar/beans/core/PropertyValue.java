package com.github.watertreestar.beans.core;

/**
 * @Author ranger
 * @Date 2020/9/6 21:17
 **/
public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public Object getValue(){
        return this.value;
    }
}
