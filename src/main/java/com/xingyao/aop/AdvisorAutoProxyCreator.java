package com.xingyao.aop;

import com.xingyao.aop.pointcut.PointCut;
import com.xingyao.ioc.extension.BeanFactoryAware;
import com.xingyao.ioc.extension.BeanPostProcessor;
import com.xingyao.ioc.factory.BeanFactory;
import com.xingyao.util.ClassUtils;
import com.xingyao.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author ranger
 * @Date 2020/11/9 20:41
 **/
public class AdvisorAutoProxyCreator implements BeanPostProcessor, AdvisorRegistry, BeanFactoryAware {

    private List<Advisor> advisors;

    private BeanFactory beanFactory;

    public AdvisorAutoProxyCreator() {
        this.advisors = new ArrayList<>();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return null;
    }

    @Override
    public void registerAdvisor(Advisor advisor) {
        this.advisors.add(advisor);
    }

    @Override
    public List<Advisor> getAdvisors() {
        return advisors;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    //在此判断bean是否需要进行切面增强
    private List<Advisor> getMatchedAdvisors(Object bean, String beanName) {
        if (CollectionUtils.isEmpty(advisors)) {
            return null;
        }

        // 得到类、类的所有方法
        Class<?> beanClass = bean.getClass();
        List<Method> allMethods = this.getAllMethodForClass(beanClass);

        // 存放匹配的Advisor的list
        List<Advisor> matchAdvisors = new ArrayList<>();
        // 遍历Advisor来找匹配的
        for (Advisor ad : this.advisors) {
            if (isPointcutMatchBean(ad, beanClass, allMethods)) {
                matchAdvisors.add(ad);
            }
        }

        return matchAdvisors;
    }

    //获取类的所有方法,包括继承的父类和实现的接口里面的方法
    private List<Method> getAllMethodForClass(Class<?> beanClass) {
        List<Method> allMethods = new LinkedList<>();
        //获取beanClass的所有接口
        Set<Class<?>> classes = new LinkedHashSet<>(ClassUtils.getAllInterfacesForClassAsSet(beanClass));
        classes.add(beanClass);

        //遍历所有的类和接口反射获取到所有的方法
        for (Class<?> clazz : classes) {
            Method[] methods = ReflectionUtils.getAllDeclaredMethods(clazz);
            for (Method m : methods) {
                allMethods.add(m);
            }
        }
        return allMethods;
    }


    private boolean isPointcutMatchBean(Advisor pa, Class<?> beanClass, List<Method> methods) {
        PointCut p = pa.getPointCut();

        // 首先判断类是否匹配
        if (!p.matchClass(beanClass)) {
            return false;
        }

        // 再判断是否有方法匹配
        for (Method method : methods) {
            if (p.matchMethod(method, beanClass)) {
                return true;
            }
        }
        return false;
    }
}
