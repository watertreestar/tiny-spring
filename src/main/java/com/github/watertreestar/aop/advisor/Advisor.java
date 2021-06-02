package com.github.watertreestar.aop.advisor;

import com.github.watertreestar.aop.advice.Advice;
import com.github.watertreestar.aop.pointcut.PointCut;

/**
 * @Author ranger
 * @Date 2020/11/9 20:05
 * 一个Advisor持有Advice和PointCut
 **/
public interface Advisor {
    Advice getAdvice();

    PointCut getPointCut();
}
