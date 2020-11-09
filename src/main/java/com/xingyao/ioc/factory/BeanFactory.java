package com.xingyao.ioc.factory;

/**
 * @Author ranger
 * @Date 2020/9/6 21:24
 **/
public interface BeanFactory {
    /**
     * 通过beanName获取一个bean
     * @param name
     * @return
     */
    Object getBean(String name);

    /**
     * 通过beanClass获取一个bean
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getBean(Class<T> clazz);


    <T> T getBean(String name,Class<T> requireType);
}
