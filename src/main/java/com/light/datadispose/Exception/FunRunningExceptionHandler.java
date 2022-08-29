package com.light.datadispose.Exception;

import com.light.datadispose.model.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义异常处理器
 */
@RestControllerAdvice
public class FunRunningExceptionHandler {

    @ExceptionHandler(FunRunningException.class)
    public Result handleAuthorizationException(Exception e) {

        return Result.FunRunningError();
    }

}
