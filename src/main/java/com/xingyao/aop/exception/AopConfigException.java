package com.xingyao.aop.exception;

/**
 * @Author ranger
 * @Date 2020/11/11 12:25
 * Exception for illegal AOP configuration
 **/
public class AopConfigException extends RuntimeException {
    public AopConfigException(String message) {
        super(message);
    }

    public AopConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}
