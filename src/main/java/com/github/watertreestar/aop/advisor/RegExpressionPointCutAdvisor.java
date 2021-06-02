package com.github.watertreestar.aop.advisor;

import com.github.watertreestar.aop.advice.Advice;
import com.github.watertreestar.aop.pointcut.PointCut;
import com.github.watertreestar.aop.pointcut.RegExpressionPointCut;
import com.github.watertreestar.aop.pointcut.PointCut;
import com.github.watertreestar.aop.pointcut.RegExpressionPointCut;

/**
 * @Author ranger
 * @Date 2020/11/9 20:35
 **/
public class RegExpressionPointCutAdvisor extends BeanFactoryPointCutAdvisor {

    private RegExpressionPointCut pointCut;

    public RegExpressionPointCutAdvisor(Advice advice, RegExpressionPointCut pointCut){
        setAdvice(advice);
        this.pointCut = pointCut;
    }

    public RegExpressionPointCutAdvisor(Advice advice,String expression){
        setAdvice(advice);
        this.pointCut = new RegExpressionPointCut(expression);
    }



    @Override
    public PointCut getPointCut() {
        return null;
    }
}
