package com.xingyao.aop;

import com.xingyao.aop.pointcut.PointCut;

/**
 * @Author ranger
 * @Date 2020/11/9 20:05
 * 一个Advisor持有Advice和PointCut
 **/
public interface Advisor {
    Advice getAdvice();

    PointCut getPointCut();
}
