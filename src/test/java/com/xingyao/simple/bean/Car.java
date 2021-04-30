package com.xingyao.simple.bean;

/**
 * @Author ranger
 * @Date 2020/9/6 15:54
 **/
public class Car {

    String name;

    String length;

    String width;

    String height;

    Wheel wheel;

    public String toString(){
        return this.name + " " + this.height + " " + this.wheel;
    }
}
