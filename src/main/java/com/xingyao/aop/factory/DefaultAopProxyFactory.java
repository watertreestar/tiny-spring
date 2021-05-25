package com.xingyao.aop.factory;

import com.xingyao.aop.*;
import com.xingyao.beans.extension.BeanFactoryAware;
import com.xingyao.beans.factory.BeanFactory;

import java.util.List;

/**
 * @Author ranger
 * @Date 2020/11/11 19:52
 **/
public class DefaultAopProxyFactory implements AopProxyFactory, BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public AopProxy createAopProxy(Object bean, String beanName, List<Advisor> matchedAdvisors) {
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setAdvisors(matchedAdvisors);
        advisedSupport.setTarget(bean);
        advisedSupport.setBeanName(beanName);
        if(useCglibProxy(advisedSupport)){
            return new CglibDynamicAopProxy(advisedSupport);
        }else{
            return new JdkDynamicAopProxy(advisedSupport);
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    protected boolean useCglibProxy(AdvisedSupport advisedSupport){
        return false;
    }
}
