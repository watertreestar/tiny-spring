package com.xingyao.ioc.xml;

import com.xingyao.ioc.core.BeanDefinition;
import com.xingyao.ioc.core.BeanReference;
import com.xingyao.ioc.core.PropertyValue;
import com.xingyao.ioc.core.PropertyValues;
import com.xingyao.ioc.extension.BeanPostProcessor;
import com.xingyao.ioc.extension.InitializeBean;
import com.xingyao.ioc.factory.BeanFactory;
import com.xingyao.ioc.factory.BeanRegistry;
import com.xingyao.ioc.reader.BeanDefinitionReader;

import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
            // ignore or note ex
            System.out.println(e.getMessage());
            e.printStackTrace();
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
        BeanDefinition beanDefinition = this.beanDefinitionMap.get(name);
        if(beanDefinition == null){

        }
        Class beanClass = beanDefinition.getClassType();
        // 反射创建bean实例
        Object bean = null;
        try{
            bean = beanClass.newInstance();
        }catch (Exception e){
            throw new IllegalStateException("Initialize bean error");
        }
        if(bean != null){
            this.createBean(bean,beanDefinition);
            try{
                this.initializeBean(bean,name);
            }catch (Exception e){
                // TODO  handle Exception while initialize bean
            }

        }
        return bean;
    }

    /**
     * 设置bean的属性
     * @param bean
     * @param bd
     */
    private void createBean(Object bean,BeanDefinition bd){
        // todo fix: 如果PropertyValue种包含了没有的字段呢？ 岂不是就异常了，所以不应该以配置的Property为主导
        PropertyValues pvs = bd.getPropertyValues();
        for(PropertyValue pv : pvs.getPropertyValues()){
            Object value = pv.getValue();

            /**
             * TODO  fix: circle dependency
             */
            if(value instanceof BeanReference){
                String refName = ((BeanReference) value).getName();
                value = this.getBean(refName);
            }
            try {
                // 首先使用setter来注入
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + pv.getName().substring(0, 1).toUpperCase()
                                + pv.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (Exception e) {
                try{
                    // setter注入失败，使用字段注入
                    Field declaredField = bean.getClass().getDeclaredField(pv.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(bean, value);
                }catch (Exception se){
                    throw new IllegalStateException("populate property failded");
                }

            }
        }
    }

    /**
     * 初始化bean, apply all beanPostProcessors
     * TODO add postConstruct
     * @param bean
     * @param name
     */
    private void initializeBean(Object bean,String name) throws Exception{
        // apply postProcessBeforeInitialization
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            beanPostProcessor.postProcessBeforeInitialization(bean,name);
        }
        // call InitializeBean.afterPropertiesSet()
        if(bean instanceof InitializeBean){
            ((InitializeBean) bean).afterPropertiesSet();
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            beanPostProcessor.postProcessAfterInitialization(bean,name);
        }
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) {
        Object bean = this.getBean(name);
        if(bean != null && !requireType.isInstance(bean)){
            throw new IllegalStateException("wrong bean type");
        }
        return (T)bean;
    }


}
