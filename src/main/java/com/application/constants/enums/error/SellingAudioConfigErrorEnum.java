package com.application.constants.enums.error;

/**
 * 无人售卖车语音配置的异常枚举
 */
public enum SellingAudioConfigErrorEnum {

    ;

    private String code;
    private String message;

    SellingAudioConfigErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}