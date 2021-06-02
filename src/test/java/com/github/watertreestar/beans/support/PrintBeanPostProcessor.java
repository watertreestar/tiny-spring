package com.github.watertreestar.beans.support;

import com.github.watertreestar.beans.extension.BeanPostProcessor;

/**
 * @Author ranger
 * @Date 2020/9/13 23:29
 **/
public class PrintBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("bean前置处理:"+ beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("bean后置处理:"+ beanName);
        return bean;
    }
}
