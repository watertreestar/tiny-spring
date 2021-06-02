package com.github.watertreestar.aop;

import java.util.List;

/**
 * @Author ranger
 * @Date 2020/10/4 10:20
 **/
public abstract class AbstractAopProxy implements AopProxy{
    private AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised){
        this.advised = advised;
    }

    public AdvisedSupport getAdvise(){
        return this.advised;
    }

    protected Object getTarget(){
        return this.advised.getTarget();
    }

    protected String getBeanName(){
        return this.advised.getBeanName();
    }

    protected List<Advisor> getMatchedAdvisor(){
        return advised.getAdvisors();
    }
}

