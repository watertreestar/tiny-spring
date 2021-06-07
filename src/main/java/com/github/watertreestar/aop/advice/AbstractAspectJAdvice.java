package com.github.watertreestar.aop.advice;

import com.github.watertreestar.aop.pointcut.AspectJExpressionPointCut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/21 14:04
 * 基于AspectJ实现的增强
 **/
public abstract class AbstractAspectJAdvice implements Advice {
    /**
     * 增强的方法
     */
    private Method adviceMethod;

    /**
     * 增强方法所属的实例对象
     */
    private Object adviceObject;


    private final Class<?>[] parameterTypes;

    public AbstractAspectJAdvice(Method adviceMethod,Object adviceObject){
        this.adviceMethod = adviceMethod;
        this.adviceObject = adviceObject;
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
