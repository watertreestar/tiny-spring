package com.github.watertreestar.aop;

import com.github.watertreestar.aop.advice.Advice;
import com.github.watertreestar.aop.advisor.Advisor;
import com.github.watertreestar.aop.pointcut.PointCut;
import com.github.watertreestar.aop.support.AdvisedSupport;
import com.github.watertreestar.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
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

    protected List<Advice> getMatchedAdvice(Method method){
        List<Advisor> candidateAdvisor = advised.getAdvisors();
        if(CollectionUtils.isEmpty(candidateAdvisor)) {
            return Collections.EMPTY_LIST;
        }
        List<Advice> advices = new ArrayList<>();
        for(Advisor advisor : candidateAdvisor) {
            PointCut pointCut = advisor.getPointCut();
            Class<?> targetClass = advised.getTarget().getClass();
            if (pointCut.matchClass(targetClass) && pointCut.matchMethod(method,targetClass)) {
                advices.add(advisor.getAdvice());
            }
        }
        return advices;
    }
}

