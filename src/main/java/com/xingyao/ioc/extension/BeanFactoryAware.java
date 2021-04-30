package com.xingyao.ioc.extension;

import com.xingyao.ioc.factory.BeanFactory;

/**
 * @Author ranger
 * @Date 2020/9/6 21:28
 **/
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory);
}
