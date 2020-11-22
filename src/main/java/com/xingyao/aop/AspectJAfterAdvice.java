package com.xingyao.aop;

import com.xingyao.aop.pointcut.AspectJExpressionPointCut;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/21 14:02
 **/
public class AspectJAfterAdvice extends AbstractAspectJAdvice implements MethodInterceptor  {

    public AspectJAfterAdvice(Method adviceMethod,Object adviceObject, AspectJExpressionPointCut pointCut){
        super(adviceMethod,adviceObject,pointCut);
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
