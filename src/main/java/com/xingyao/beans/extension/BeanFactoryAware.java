package com.xingyao.beans.extension;

import com.xingyao.beans.factory.BeanFactory;

/**
 * @Author ranger
 * @Date 2020/9/6 21:28
 **/
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory);
}
