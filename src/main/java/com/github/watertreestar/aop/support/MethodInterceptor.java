package com.github.watertreestar.aop.support;

/**
 * @Author ranger
 * @Date 2020/11/19 21:22
 **/
public interface MethodInterceptor {
    Object invoke(MethodInvocation invocation) throws Throwable;
}
