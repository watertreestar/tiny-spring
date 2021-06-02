package com.github.watertreestar.core;

/**
 * @Author ranger
 * @Date 2020/11/9 20:09
 **/
public interface Ordered {
    Integer MINIMALITY_ORDER = Integer.MIN_VALUE;

    Integer MAXIMUN_ORDER = Integer.MAX_VALUE;

    int getOrder();
}
