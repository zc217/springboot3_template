package com.zhou.common.exception;

import com.zhou.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result handleException(BusinessException e) {
        log.error("业务异常:{}",e.getMessage());
        return Result.faild(e.getCode(), e.getMessage());
    }
}
