package com.github.watertreestar.aop;

import com.github.watertreestar.aop.advisor.Advisor;
import com.github.watertreestar.aop.factory.AopProxyFactory;
import com.github.watertreestar.aop.pointcut.PointCut;
import com.github.watertreestar.beans.extension.BeanFactoryAware;
import com.github.watertreestar.beans.extension.BeanPostProcessor;
import com.github.watertreestar.beans.factory.BeanFactory;
import com.github.watertreestar.util.ClassUtils;
import com.github.watertreestar.util.CollectionUtils;
import com.github.watertreestar.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author ranger
 * @Date 2020/11/9 20:41
 * 创建切面
 **/
public class AdvisorAutoProxyCreator implements BeanPostProcessor, AdvisorRegistry, BeanFactoryAware {

    private List<Advisor> advisors;

    private BeanFactory beanFactory;

    public AdvisorAutoProxyCreator() {
        this.advisors = new ArrayList<>();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        // 获取满足此bean的advisor
        List<Advisor> matchedAdvisors = this.getMatchedAdvisors(bean, beanName);
        // 对advisor进行排序

        // 生成代理，织入advisor
        if(matchedAdvisors.size() > 0) {
            return this.createProxy(bean, beanName, matchedAdvisors);
        }
        return bean;
    }

    private Object createProxy(Object bean, String beanName, List<Advisor> matchedAdvisor) {
        Object proxy = AopProxyFactory.getDefaultAopProxyFactory()
                .createAopProxy(bean, beanName, matchedAdvisor).getProxy();
        return proxy;
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

    /**
     * 获取匹配的Advisor
     *
     * @param bean
     * @param beanName
     * @return
     */
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

    /**
     * 获取类中所有的方法
     *
     * @param beanClass
     * @return
     */
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


    /**
     * 该advisor是否匹配该类
     *
     * @param advisor
     * @param beanClass
     * @param methods
     * @return
     */
    private boolean isPointcutMatchBean(Advisor advisor, Class<?> beanClass, List<Method> methods) {
        PointCut p = advisor.getPointCut();

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
