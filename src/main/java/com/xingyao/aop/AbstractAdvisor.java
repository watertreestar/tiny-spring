package com.xingyao.aop;

import com.xingyao.aop.pointcut.PointCut;
import com.xingyao.core.Ordered;

/**
 * @Author ranger
 * @Date 2020/11/9 20:09
 **/
public abstract class AbstractAdvisor implements Advisor, Ordered {

    private Integer order;

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        if(this.order != null){
            return this.order;
        }
        Advice advice = this.getAdvice();
        if(advice instanceof Ordered){
            return ((Ordered) advice).getOrder();
        }
        return Ordered.MINIMALITY_ORDER;
    }
}
