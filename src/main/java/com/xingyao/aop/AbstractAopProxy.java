package com.xingyao.aop;

/**
 * @Author ranger
 * @Date 2020/10/4 10:20
 **/
public abstract class AbstractAopProxy implements AopProxy{
    private AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised){
        this.advised = advised;
    }
}

