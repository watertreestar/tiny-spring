package com.github.watertreestar.aop.advice;

import com.github.watertreestar.aop.support.MethodInterceptor;
import com.github.watertreestar.aop.support.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/22 12:28
 **/
public class BeforeAdviceInterceptor extends AbstractAdvice implements MethodInterceptor {

    public BeforeAdviceInterceptor(Method adviceMethod, Object adviceObject){
        super(adviceMethod,adviceObject);
    }
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        this.invokeAdviceMethod();
        try{
            return invocation.process();
        }catch (Throwable t){
            throw t;
        }

    }
}
