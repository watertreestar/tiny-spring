package com.github.watertreestar.aop.advisor;

import com.github.watertreestar.aop.pointcut.AspectJExpressionPointCut;
import com.github.watertreestar.aop.pointcut.PointCut;
import com.github.watertreestar.aop.pointcut.AspectJExpressionPointCut;
import com.github.watertreestar.aop.pointcut.PointCut;

/**
 * @Author ranger
 * @Date 2020/11/9 20:16
 * 切面包含了切点和advice
 **/
public class AspectJPointCutAdvisor extends BeanFactoryPointCutAdvisor {

    private AspectJExpressionPointCut pointCut;

    public AspectJPointCutAdvisor(Advice advice,AspectJExpressionPointCut pointCut){
        setAdvice(advice);
        this.pointCut = pointCut;
    }

    public AspectJPointCutAdvisor(Advice advice,String expression){
        setAdvice(advice);
        this.pointCut = new AspectJExpressionPointCut(expression);
    }


    @Override
    public PointCut getPointCut() {
        return this.pointCut;
    }
}
