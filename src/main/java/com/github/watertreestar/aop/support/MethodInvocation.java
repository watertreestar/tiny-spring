package com.github.watertreestar.aop.support;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/19 21:26
 * target method
 **/
public interface MethodInvocation {
    Object process()  throws Throwable;

    Object[] getArguments();

    Method getMethod();
}
