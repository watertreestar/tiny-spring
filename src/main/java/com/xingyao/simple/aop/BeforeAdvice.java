package com.xingyao.simple.aop;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/9/6 16:06
 * 前置通知，包含了增强逻辑Invocation和被代理对象
 **/
public class BeforeAdvice extends Advice {

    public BeforeAdvice(Object bean,Invocation invocation){
        this.bean = bean;
        this.invocation = invocation;
    }

    /**
     * 真实调用的对象
     */
    private Object bean;

    /**
     * 前置通知逻辑的对象
     */
    private Invocation invocation;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 先执行前置通知逻辑
        invocation.invoke();
        return method.invoke(bean,args);
    }
}
