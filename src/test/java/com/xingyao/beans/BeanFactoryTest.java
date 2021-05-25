package com.xingyao.beans;

import com.xingyao.beans.factory.BeanFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author ranger
 * @Date 2020/9/13 23:05
 **/
public class BeanFactoryTest {
    String configLocation;
    @Before
    public void setUp(){
        configLocation = this.getClass().getClassLoader().getResource("bean-factory.xml").getFile();
    }


    @Test
    public void run(){
        BeanFactory beanFactory = new com.xingyao.beans.xml.XmlBeanFactory(configLocation);
        Object car = beanFactory.getBean("car");
        System.out.println(car);
        Assert.assertNotNull(car);
    }
}
