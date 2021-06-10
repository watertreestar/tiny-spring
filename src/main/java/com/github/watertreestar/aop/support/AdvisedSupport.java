package com.github.watertreestar.aop.support;

import com.github.watertreestar.aop.advisor.Advisor;

import java.util.List;

/**
 * @Author ranger
 * @Date 2020/10/4 10:21
 * 代理相关的元数据,包含了代理累的各种配置
 *
 * 代理的创建是基于类级别的，一个类的示例创建一个代理对象，在代理对象的invoke方法中需要选择出匹配的advice来执行
 *
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
