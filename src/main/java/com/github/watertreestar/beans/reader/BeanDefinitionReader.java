package com.github.watertreestar.beans.reader;

/**
 * @Author ranger
 * @Date 2020/9/6 21:23
 **/
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String configLocation) throws Exception;
}
