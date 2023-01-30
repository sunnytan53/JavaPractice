package org.sunny.controller;

public class Result {
    private Integer code;
    private Object data;
    private String msg;

    // remember it is better to have a no-arg constructor
    public Result() {
    }

    public Result(Object data, ResultCode code) {
        this.code = code.getCode();
        this.data = data;
        this.msg = "";
    }

    public Result(Object data, ResultCode code, String msg) {
        this.code = code.getCode();
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
