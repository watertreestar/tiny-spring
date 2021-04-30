package com.xingyao.aop;

import com.xingyao.aop.pointcut.AspectJExpressionPointCut;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/22 12:28
 **/
public class AspectJBeforeAdvice extends AbstractAspectJAdvice implements MethodInterceptor  {

    public AspectJBeforeAdvice(Method adviceMethod, Object adviceObject, AspectJExpressionPointCut pointCut){
        super(adviceMethod,adviceObject,pointCut);
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
