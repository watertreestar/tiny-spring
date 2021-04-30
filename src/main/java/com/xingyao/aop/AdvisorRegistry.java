package com.xingyao.aop;

import java.util.List;

/**
 * @Author ranger
 * @Date 2020/11/9 20:41
 * 注册Advisor
 **/
public interface AdvisorRegistry {
    void registerAdvisor(Advisor advisor);

    List<Advisor> getAdvisors();
}
