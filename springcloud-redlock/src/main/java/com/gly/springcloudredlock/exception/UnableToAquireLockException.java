package com.gly.springcloudredlock.exception;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudredlock.exception
 *          自定义异常类
 * @date:2019/6/3
 **/
public class UnableToAquireLockException extends RuntimeException{
    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
