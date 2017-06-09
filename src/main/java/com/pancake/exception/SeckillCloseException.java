package com.pancake.exception;

/**
 * 秒杀关闭异常
 * Created by m on 2017/6/9.
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
