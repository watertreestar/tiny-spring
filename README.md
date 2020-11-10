# tiny-spring

:blush:简单阅读了Spring关于IOC和AOP的源码后，加上参考其他人的思路，实现一个简单(玩具版)的IOC容器，同时实现了AOP的功能
主要目的是为了帮助理解Spring中两个最重要的东西-IOC和AOP，:heartpulse:

## 项目结构:closed_umbrella:

```shell
`-
 |-- aop      # 实现AOP相关
 |-- core     # 核心类
 |-- ioc      # 实现IOC相关
 |-- simple   # 简单的IOC和AOP实现
 |-- util     # 工具类
```


## 简单的IOC和AOP的实现  :strawberry:

- SimpleIOC容器可以解析xml文件中定义的bean标签，根据此定义来实现依赖注入。

- SimpleAOP使用了JDK动态代理来实现。定了了BeforeAdvice来实现前置增强


## 


   