package com.xingyao.aop;

import com.xingyao.aop.pointcut.AspectJExpressionPointCut;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/22 12:42
 **/
public class AspenctJAroundAdvice extends AbstractAspectJAdvice implements MethodInterceptor{
    public AspenctJAroundAdvice(Method adviceMethod, Object adviceObject, AspectJExpressionPointCut pointCut) {
        super(adviceMethod, adviceObject, pointCut);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return this.invokeAdviceMethod();
    }
}
