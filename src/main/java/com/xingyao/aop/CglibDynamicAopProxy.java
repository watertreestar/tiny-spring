package com.xingyao.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/11 12:04
 **/
public class CglibDynamicAopProxy extends AbstractAopProxy implements MethodInterceptor {


    private static Enhancer enhancer = new Enhancer();

    public CglibDynamicAopProxy(AdvisedSupport advisedSupport){
        super(advisedSupport);
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
