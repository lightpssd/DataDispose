package com.light.datadispose.Exception;

import com.light.datadispose.model.MyResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义异常处理器
 */
@RestControllerAdvice
public class FunRunningExceptionHandler {

    @ExceptionHandler(FunRunningException.class)
    public MyResult handleAuthorizationException(Exception e) {

        return MyResult.FunRunningError();
    }

}
