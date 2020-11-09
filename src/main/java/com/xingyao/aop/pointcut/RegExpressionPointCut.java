package com.xingyao.aop.pointcut;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/9 19:37
 * 使用正则来匹配切点
 **/
public class RegExpressionPointCut extends ExpressionPointCut {
    public RegExpressionPointCut(String expression) {
        super(expression);
    }

    @Override
    public boolean matchClass(Class<?> targetClass) {
        return false;
    }

    @Override
    public boolean matchMethod(Method method, Class<?> targetClass) {
        return false;
    }
}
