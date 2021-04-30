package com.xingyao.simple.aop;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author ranger
 * @Date 2020/9/6 16:13
 **/
public class AOPTest {
    String configLocation;
    @Before
    public void setUp(){
        configLocation = this.getClass().getClassLoader().getResource("ioc.xml").getFile();
    }


    @Test
    public void run(){
        /**
         * 增强逻辑
         */
        Invocation invocation = () -> {
            System.out.println("前置操作");
            return null;
        };

        UserService userService = new UserServiceImpl();
        BeforeAdvice beforeAdvice = new BeforeAdvice(userService,invocation);

        UserService userServicePoxy = (UserService) SimpleAOP.createProxy(userService,beforeAdvice);
        userServicePoxy.save();
    }
}
