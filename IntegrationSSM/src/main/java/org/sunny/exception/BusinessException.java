package org.sunny.exception;

import org.sunny.controller.ResultCode;

public class BusinessException extends RuntimeException {
    private ResultCode resultCode;

    public BusinessException(String message, ResultCode resultCode) {
        super(message);
        this.resultCode = resultCode;
    }

    public BusinessException(String message, Throwable cause, ResultCode resultCode) {
        super(message, cause);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
