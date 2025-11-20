package com.realman.SchoolSystem.exception;

import com.realman.SchoolSystem.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("Exception: {}", e.getMessage());
        return Result.error("Something Wrong");
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("Something wrong:{}",e.getMessage());
        String message =e.getMessage();
        int i= message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr =errMsg.split( " ");
        return Result.error( arr[2]+"already exist");
    }
}
