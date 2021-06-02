package com.github.watertreestar.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ranger
 * @Date 2020/11/9 20:55
 * utils for reflection
 **/
public class ReflectionUtils {

    /*
     * following methods are from Spring Util
     *
     * */

    /**
     * 获取类中所有的方法，包括接口和父类
     *
     * @param leafClass
     * @return
     */
    public static Method[] getAllDeclaredMethods(Class<?> leafClass) {
        final List<Method> methods = new ArrayList<>(32);
        doWithMethods(leafClass, methods::add);
        return methods.toArray(new Method[0]);
    }

    /**
     * @param clazz
     * @param mc
     */
    public static void doWithMethods(Class<?> clazz, MethodCallback mc) {
        Method[] methods = getDeclaredMethods(clazz);
        for (Method method : methods) {

            try {
                mc.doWith(method);
            } catch (IllegalAccessException ex) {
                throw new IllegalStateException("Not allowed to access method '" + method.getName() + "': " + ex);
            }
        }
        if (clazz.getSuperclass() != null) {
            doWithMethods(clazz.getSuperclass(), mc);
        } else if (clazz.isInterface()) {
            for (Class<?> superIfc : clazz.getInterfaces()) {
                doWithMethods(superIfc, mc);
            }
        }
    }


    /**
     * 获取类所有的方法，包括接口中定义的默认方法，不包括superClass,
     *
     * @param clazz
     * @return
     */
    private static Method[] getDeclaredMethods(Class<?> clazz) {
        Method[] result = null;
        if (result == null) {
            try {
                Method[] declaredMethods = clazz.getDeclaredMethods();
                List<Method> defaultMethods = findConcreteMethodsOnInterfaces(clazz);
                if (defaultMethods != null) {
                    result = new Method[declaredMethods.length + defaultMethods.size()];
                    System.arraycopy(declaredMethods, 0, result, 0, declaredMethods.length);
                    int index = declaredMethods.length;
                    for (Method defaultMethod : defaultMethods) {
                        result[index] = defaultMethod;
                        index++;
                    }
                } else {
                    result = declaredMethods;
                }
            } catch (Throwable ex) {
                throw new IllegalStateException("Failed to introspect Class [" + clazz.getName() +
                        "] from ClassLoader [" + clazz.getClassLoader() + "]", ex);
            }
        }
        return result;
    }

    /**
     * 获取接口中的默认方法  JDK8中接口可以定义默认方法
     * @param clazz
     * @return
     */
    private static List<Method> findConcreteMethodsOnInterfaces(Class<?> clazz) {
        List<Method> result = null;
        for (Class<?> ifc : clazz.getInterfaces()) {
            for (Method ifcMethod : ifc.getMethods()) {
                if (!Modifier.isAbstract(ifcMethod.getModifiers())) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(ifcMethod);
                }
            }
        }
        return result;
    }

    @FunctionalInterface
    public interface MethodCallback {

        /**
         * Perform an operation using the given method.
         *
         * @param method the method to operate on
         */
        void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
    }
}
