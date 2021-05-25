package com.xingyao.beans.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ranger
 * @Date 2020/9/6 21:17
 **/
public class PropertyValues {

    private List<PropertyValue> values;

    public PropertyValues(List<PropertyValue> values) {
        this.values = values;
    }

    public PropertyValues(){
        values = new ArrayList<>();;
    }

    public void addPropertyValue(PropertyValue pv){
        this.values.add(pv);
    }

    public List<PropertyValue> getPropertyValues(){
        return this.values;
    }
}
