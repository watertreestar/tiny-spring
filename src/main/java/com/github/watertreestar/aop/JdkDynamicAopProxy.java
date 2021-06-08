package com.github.watertreestar.aop;

import com.github.watertreestar.aop.support.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ranger
 * @Date 2020/10/4 10:22
 * 基于JDK 动态代理生成代理对象
 **/
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport){
        // todo check arguments
        super(advisedSupport);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getTarget().getClass().getClassLoader(),
                getTarget().getClass().getInterfaces(),this);
    }

    /**
     * 动态代理对象
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // todo 执行当前方法匹配的Advisor

        return null;
    }
}
