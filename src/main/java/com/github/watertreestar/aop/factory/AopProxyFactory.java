package com.github.watertreestar.aop.factory;

import com.github.watertreestar.aop.Advisor;
import com.github.watertreestar.aop.Advisor;
import com.github.watertreestar.aop.AopProxy;

import java.util.List;

/**
 * @Author ranger
 * @Date 2020/11/11 12:17
 * 创建AopProxy对象
 **/
public interface AopProxyFactory {
    AopProxy createAopProxy(Object bean, String beanName, List<Advisor> matchedAdvisors);

    static AopProxyFactory getDefaultAopProxyFactory(){
        return new DefaultAopProxyFactory();
    }
}
