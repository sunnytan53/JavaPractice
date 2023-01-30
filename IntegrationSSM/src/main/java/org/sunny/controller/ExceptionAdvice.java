package org.sunny.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.sunny.exception.BusinessException;
import org.sunny.exception.SystemException;

@RestControllerAdvice
public class ExceptionAdvice {
    // specify what exception to handle in this method
    @ExceptionHandler(SystemException.class)
    public Result handleException(SystemException e) {
        // record the log, these are known and big exceptions
        return new Result(null, e.getResultCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result handleException(BusinessException e) {
        // nothing to record, because these are predicted exception
        return new Result(null, e.getResultCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        // record the log, these are unknown exceptions,
        // which are more important to evaluate
        return new Result(null, ResultCode.SYSTEM_UNKNOWN_ERR, "server is busy... (unhandled error)");
    }
}
