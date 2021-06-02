package com.github.watertreestar.simple.aop;

import com.github.watertreestar.simple.ioc.SimpleIOC;

import java.lang.reflect.Proxy;

/**
 * @Author ranger
 * @Date 2020/9/6 15:46
 * 给指定对象创建代理
 **/
public class SimpleAOP {
    public static Object createProxy(Object bean, Advice advice){
        return Proxy.newProxyInstance(SimpleIOC.class.getClassLoader(),bean.getClass().getInterfaces(),advice);
    }
}
