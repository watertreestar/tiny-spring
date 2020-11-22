package com.xingyao.aop;

import com.xingyao.aop.pointcut.AspectJExpressionPointCut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/21 14:04
 **/
public abstract class AbstractAspectJAdvice implements Advice {
    private Method adviceMethod;

    private Object adviceObject;

    private AspectJExpressionPointCut pointCut;

    private final Class<?>[] parameterTypes;

    public AbstractAspectJAdvice(Method adviceMethod,Object adviceObject,AspectJExpressionPointCut pointCut){
        this.adviceMethod = adviceMethod;
        this.adviceObject = adviceObject;
        this.pointCut = pointCut;
        this.parameterTypes = adviceMethod.getParameterTypes();
    }

    /**
     * invoke advice method
     *
     * @return
     */
    protected Object invokeAdviceMethod() throws Throwable {
       // invoke method
        try {
            return adviceMethod.invoke(adviceObject);
        } catch (IllegalAccessException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        }catch (InvocationTargetException e){
            throw e;
        }
    }
}
