package com.github.watertreestar.aop.pointcut;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/9 19:36
 * 切点定义
 **/
public interface PointCut {
    boolean matchClass(Class<?> targetClass);

    boolean matchMethod(Method method, Class<?> targetClass);
}
