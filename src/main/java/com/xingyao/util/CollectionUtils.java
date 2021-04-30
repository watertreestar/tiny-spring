package com.xingyao.util;

import java.util.Collection;

/**
 * @Author ranger
 * @Date 2020/11/9 20:45
 **/
public class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }
}
