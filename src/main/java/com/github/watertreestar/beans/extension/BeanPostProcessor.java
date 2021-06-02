package com.github.watertreestar.beans.extension;

/**
 * @Author ranger
 * @Date 2020/9/6 21:28
 * Bean后置处理器
 **/
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean,String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean,String beanName) throws Exception;
}
