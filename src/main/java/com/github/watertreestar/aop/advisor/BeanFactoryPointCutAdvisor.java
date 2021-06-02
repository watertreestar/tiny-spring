package com.github.watertreestar.aop.advisor;

import com.github.watertreestar.aop.advice.Advice;
import com.github.watertreestar.beans.extension.BeanFactoryAware;
import com.github.watertreestar.beans.factory.BeanFactory;

/**
 * @Author ranger
 * @Date 2020/11/9 20:20
 * BeanNamePointCutAdvisor 实现了可以从BeanFactory中获取Advice
 **/
public abstract class BeanFactoryPointCutAdvisor extends AbstractAdvisor implements BeanFactoryAware {

    private String adviceBeanName;

    private BeanFactory beanFactory;

    private Advice advice;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void setAdviceBeanName(String adviceBeanName) {
        this.adviceBeanName = adviceBeanName;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        Advice advice = this.advice;
        if (advice != null) {
            return advice;
        }
        if(beanFactory == null || this.adviceBeanName == null){
            throw new IllegalStateException("beanFactory or adviceBeanName must be set");
        }
        advice = beanFactory.getBean(adviceBeanName,Advice.class);
        this.advice = advice;
        return advice;

    }
}
