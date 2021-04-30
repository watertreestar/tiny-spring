package com.xingyao.aop.pointcut;

/**
 * @Author ranger
 * @Date 2020/11/9 19:38
 **/
public abstract class ExpressionPointCut implements PointCut{
    private String expression;

    public ExpressionPointCut(String expression){
        this.expression = expression;
    }

    String  getExpression(){
        return this.expression;
    }
}
