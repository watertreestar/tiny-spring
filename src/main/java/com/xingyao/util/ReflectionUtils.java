package com.xingyao.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ranger
 * @Date 2020/11/9 20:55
 * reflection utils
 **/
public class ReflectionUtils {
    public static Method[] getAllDeclaredMethods(Class<?> leafClass) {
        final List<Method> methods = new ArrayList<>(32);
        // todo find all method recursive
        return methods.toArray(new Method[0]);
    }
}
