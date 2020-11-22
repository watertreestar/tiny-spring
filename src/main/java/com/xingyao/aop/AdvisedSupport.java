package com.xingyao.aop;

import java.util.List;

/**
 * @Author ranger
 * @Date 2020/10/4 10:21
 * 代理相关的元数据
 **/
public class AdvisedSupport {
    /**
     * 目标对象的beanId
     */
    private String beanName;

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 匹配目标对象的Advisor
     */
    private List<Advisor> advisors;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public List<Advisor> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(List<Advisor> advisors) {
        this.advisors = advisors;
    }
}
