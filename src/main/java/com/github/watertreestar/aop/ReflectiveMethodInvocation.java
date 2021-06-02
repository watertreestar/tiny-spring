package com.github.watertreestar.aop;

import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>
 *  Invokes the target object using reflection.
 * </p>
 * @Author ranger
 * @Date 2020/11/21 14:42
 **/
public class ReflectiveMethodInvocation implements MethodInvocation {

    protected final Object proxy;

    protected final Object target;

    protected final Method method;

    protected Object[] arguments;

    private final Class<?> targetClass;

    /**
     * List of MethodInterceptor and InterceptorAndDynamicMethodMatcher
     * that need dynamic checks.
     */
    protected final List<MethodInterceptor> interceptors;

    /**
     * Index from 0 of the current interceptor we're invoking.
     * -1 until we invoke: then the current interceptor.
     */
    private int currentInterceptorIndex = -1;

    protected ReflectiveMethodInvocation(
            Object proxy,Object target, Method method, Object[] arguments,
            Class<?> targetClass, List<MethodInterceptor> interceptors) {

        this.proxy = proxy;
        this.target = target;
        this.targetClass = targetClass;
        this.method = method;
        this.arguments = arguments;
        this.interceptors = interceptors;
    }


    public final Object getProxy() {
        return this.proxy;
    }

    public final Object getThis() {
        return this.target;
    }


    @Override
    public Object process() throws Throwable {
        if(this.currentInterceptorIndex == this.interceptors.size() - 1){
            return this.invokeJoinPoint();
        }
        this.currentInterceptorIndex++;
        MethodInterceptor interceptor =
                this.interceptors.get(this.currentInterceptorIndex);
        return interceptor.invoke(this);

    }

    protected Object invokeJoinPoint() throws Throwable{
        return this.method.invoke(target,arguments);
    }
}
