package com.xingyao.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/10/4 10:22
 * 基于JDK 动态代理生成代理对象
 **/
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport){
        super(advisedSupport);
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
