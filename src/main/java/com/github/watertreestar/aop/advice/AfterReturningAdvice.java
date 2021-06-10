package com.github.watertreestar.aop.advice;

import java.lang.reflect.Method;

/**
 * 在方法返回后增强，需要返回值
 */
public interface AfterReturningAdvice {
    void afterReturning(Object retVal, Method method, Object[] args, Object o);
}
