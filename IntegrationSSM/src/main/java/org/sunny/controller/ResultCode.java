package org.sunny.controller;

public enum ResultCode {
    SAVE_OK(20011),
    DELETE_OK(20021),
    UPDATE_OK(20031),
    GET_OK(20041),
    SAVE_ERR(20010),
    DELETE_ERR(20020),
    UPDATE_ERR(20030),
    GET_ERR(20040),
    SYSTEM_ERR(50001),
    SYSTEM_TIMEOUT_ERR(50002),
    SYSTEM_UNKNOWN_ERR(50003),
    BUSINESS_ERR(60001);

    private Integer code;

    private ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
