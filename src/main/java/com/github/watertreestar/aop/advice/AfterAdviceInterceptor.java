package com.github.watertreestar.aop.advice;

import com.github.watertreestar.aop.support.MethodInterceptor;
import com.github.watertreestar.aop.support.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/21 14:02
 **/
public class AfterAdviceInterceptor extends AbstractAdvice implements MethodInterceptor {

    public AfterAdviceInterceptor(Method adviceMethod,Object adviceObject){
        super(adviceMethod,adviceObject);
    }

    /**
     * invoke advice after target method invoked
     * @param invocation
     * @return
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        try{
            return invocation.process();
        }finally {
            invokeAdviceMethod();
        }
    }
}
