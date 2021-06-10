package com.github.watertreestar.aop;

import com.github.watertreestar.aop.advice.Advice;
import com.github.watertreestar.aop.advice.BeforeAdvice;
import com.github.watertreestar.aop.advice.BeforeAdviceInterceptor;
import com.github.watertreestar.aop.support.AdvisedSupport;
import com.github.watertreestar.aop.support.MethodInterceptor;
import com.github.watertreestar.aop.support.ReflectiveMethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

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
        List<Advice> matchedAdvice = this.getMatchedAdvice(method);
        if(matchedAdvice.size() == 0) {
            return method.invoke(proxy,args);
        }else {
            List<MethodInterceptor> interceptors = new ArrayList<>();
            for (Advice advice : matchedAdvice) {
                interceptors.add((MethodInterceptor) advice);
            }
            ReflectiveMethodInvocation invocation = new ReflectiveMethodInvocation(this,proxy,method,args,proxy.getClass(),interceptors);
            return invocation.process();
        }
    }
}
