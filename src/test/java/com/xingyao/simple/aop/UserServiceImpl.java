package com.xingyao.simple.aop;

/**
 * @Author ranger
 * @Date 2020/9/6 16:16
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存用户");
    }
}
