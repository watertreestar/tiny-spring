package com.github.watertreestar.aop.advice;

import com.github.watertreestar.aop.MethodInterceptor;
import com.github.watertreestar.aop.MethodInvocation;
import com.github.watertreestar.aop.pointcut.AspectJExpressionPointCut;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/22 12:42
 **/
public class AspectJAroundAdvice extends AbstractAspectJAdvice implements MethodInterceptor {
    public AspectJAroundAdvice(Method adviceMethod, Object adviceObject) {
        super(adviceMethod, adviceObject);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return this.invokeAdviceMethod();
    }
}
