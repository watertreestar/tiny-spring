package com.xingyao.aop;

/**
 * @Author ranger
 * @Date 2020/10/4 10:30
 * 代理目标类的信息
 **/
public class TargetSource {

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    private Object target;

    public TargetSource(Class<?> targetClass,Class<?>[] interfaces,Object target){
        this.targetClass = targetClass;
        this.interfaces = interfaces;
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class<?>[] interfaces) {
        this.interfaces = interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
