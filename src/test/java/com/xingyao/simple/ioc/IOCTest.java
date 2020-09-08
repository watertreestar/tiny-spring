package com.xingyao.simple.ioc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author ranger
 * @Date 2020/9/6 15:47
 **/
public class IOCTest {
    String configLocation;
    @Before
    public void setUp(){
        configLocation = this.getClass().getClassLoader().getResource("ioc.xml").getFile();
    }


    @Test
    public void run(){
        SimpleIOC ioc = new SimpleIOC(configLocation);
        Object car = ioc.getBean("car");
        System.out.println(car);
        Assert.assertNotNull(car);
    }


}
