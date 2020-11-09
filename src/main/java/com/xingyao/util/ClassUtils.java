package com.xingyao.util;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ranger
 * @Date 2020/11/9 20:48
 **/
public class ClassUtils {

    public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz){
        if(clazz.isInterface()){
            return Collections.singleton(clazz);
        }
        Set<Class<?>> interfaces = new LinkedHashSet<>();
        Class<?> current = clazz;
        while (current != null) {
            Class<?>[] ifcs = current.getInterfaces();
            current = current.getSuperclass();
        }
        return interfaces;
    }
}
