package com.pancake.exception;

import com.pancake.dto.SeckillExecution;
import com.pancake.entity.SuccessKilled;

/**
 * 重复秒杀异常（运行期异常）
 * Created by m on 2017/6/9.
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
