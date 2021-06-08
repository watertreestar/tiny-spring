package com.github.watertreestar.aop.advice;

import com.github.watertreestar.aop.support.MethodInterceptor;
import com.github.watertreestar.aop.support.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/22 12:42
 **/
public class AroundAdviceInterceptor extends AbstractAdvice implements MethodInterceptor {
    public AroundAdviceInterceptor(Method adviceMethod, Object adviceObject) {
        super(adviceMethod, adviceObject);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return this.invokeAdviceMethod();
    }
}
