package com.xingyao.aop.pointcut;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;

/**
 * @Author ranger
 * @Date 2020/11/9 19:40
 * 依赖aspectJ来匹配切点
 * 依赖包aspectjweaver
 **/
public class AspectJExpressionPointCut extends ExpressionPointCut {

    //获得切点解析器
    private static PointcutParser pp = PointcutParser
            .getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();

    //Pointcut表达式对象
    private PointcutExpression pe;

    public AspectJExpressionPointCut(String expression) {
        super(expression);
        //解析表达式得到org.aspectj.weaver.tools.PointcutExpression
        pe = pp.parsePointcutExpression(expression);
    }

    @Override
    public boolean matchClass(Class<?> targetClass) {
        return  pe.couldMatchJoinPointsInType(targetClass);
    }

    @Override
    public boolean matchMethod(Method method, Class<?> targetClass) {
        ShadowMatch sm = pe.matchesMethodExecution(method);
        return sm.alwaysMatches();
    }
}
