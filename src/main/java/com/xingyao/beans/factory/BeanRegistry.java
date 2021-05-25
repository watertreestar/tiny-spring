package com.xingyao.beans.factory;

import com.xingyao.beans.core.BeanDefinition;

/**
 * @Author ranger
 * @Date 2020/9/6 21:40
 **/
public interface BeanRegistry {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
