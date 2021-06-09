# tiny-spring

:blush:简单阅读了Spring关于IOC和AOP的源码后，加上参考其他人的思路，实现一个简单(玩具版)的IOC容器，同时实现了AOP的功能
主要目的是为了帮助理解Spring中两个最重要的东西-IOC和AOP，:heartpulse:

虽然取名叫做tiny-spring，其实比起Spring来说，我这个一个轮子都算不上,单纯只是为了体验Spring实现IOC和AOP的内部原理。当然依赖注入(DI)的实现方式也不是只有Spring这样，
还有必要出名的Guice也同样实现了DI

## 项目结构:closed_umbrella:

```shell
--
  |-- aop      # 实现AOP相关
  |-- core     # 核心类
  |-- beans    # 实现IOC相关
  |-- simple   # 简单的IOC和AOP实现
  |-- util     # 工具类
```

## 简单的IOC和AOP的实现  :strawberry:

- SimpleIOC容器可以解析xml文件中定义的bean标签，根据此定义来实现依赖注入。

- SimpleAOP使用了JDK动态代理来实现。定了了BeforeAdvice来实现前置增强

## IOC实现分析



## AOP实现分析

在实现AOP之前，我们先了解一下SpringAOP中的一些概念，并且要记住这些概念的含义，在后面看到这些概念对应的类才能对它的作用了然于心。
现在这个AOP还不能运行，只是为了帮助我理解一个AOP的大致过程

![image-20210602213646382](https://cdn.jsdelivr.net/gh/watertreestar/CDN@master/picimage-20210602213646382.png)

熟记上面几个很重要的概念，对代码中出现的一些类的理解非常重要。



### PointCut

大家都知道，AOP是对于一个方法的拦截，在方法执行的前后加入一些通用的逻辑，根据我们以前的知识，可以通过Java中的JDK动态代理来实现对一个类中方法的拦截，那么，我们如何知道要拦截哪个方法？对，通过配置文件配置，或者注解标识，实际上我们的配置或者注解是为了检查一个类和方法是否能够匹配，这个类也就是上图中的PointCut。

```java
public interface PointCut {
    boolean matchClass(Class<?> targetClass);

    boolean matchMethod(Method method, Class<?> targetClass);
}

```

上面的就是我们定义的PointCut接口，通过名字就能看出它的作用是检查一个类和方法是否匹配

### Advice


### Advisor


### ProxyCreator

### MethodInterceptor适配



