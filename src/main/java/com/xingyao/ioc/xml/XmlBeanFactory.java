package com.xingyao.ioc.xml;

import com.xingyao.ioc.core.BeanDefinition;
import com.xingyao.ioc.extension.BeanPostProcessor;
import com.xingyao.ioc.factory.BeanFactory;
import com.xingyao.ioc.factory.BeanRegistry;
import com.xingyao.ioc.reader.BeanDefinitionReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ranger
 * @Date 2020/9/6 21:26
 * 根据XML配置文件实现的BeanFactory
 **/
public class XmlBeanFactory implements BeanFactory, BeanRegistry {
    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();

    private Map<String,Object> beanMap = new HashMap<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private BeanDefinitionReader beanDefinitionReader;

    private String configLocation;

    public XmlBeanFactory(String configLocation){
        this.beanDefinitionReader = new XmlBeanDefinitionReader(this);
        this.configLocation = configLocation;
        try{
            // 加载所有的beanDefinition
            this.beanDefinitionReader.loadBeanDefinitions(configLocation);
            registerBeanPostProcessor();
        }catch (Exception e){
            // ignore
        }
    }

    private void registerBeanPostProcessor() {
        List<Object> postProcessors = this.getBeansForType(BeanPostProcessor.class);
        for (Object postProcessor : postProcessors) {
            this.addBeanPostProcessor((BeanPostProcessor) postProcessor);
        }
    }

    private void addBeanPostProcessor(BeanPostProcessor postProcessor){
        this.beanPostProcessors.add(postProcessor);
    }

    private List<Object> getBeansForType(Class type){
        List<Object> beans = new ArrayList<>();
        for(BeanDefinition definition : beanDefinitions){
            if(type.isAssignableFrom(definition.getClassType())){
                beans.add(getBean(definition.getName()));
            }
        }
        return beans;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(name,beanDefinition);
        this.beanDefinitions.add(beanDefinition);
    }



    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return null;
    }




}
