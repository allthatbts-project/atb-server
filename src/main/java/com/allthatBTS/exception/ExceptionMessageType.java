package com.allthatBTS.exception;

public enum ExceptionMessageType {
    TOKEN_IS_NOT_EXIST("token is not exist"),
    NOT_SUPPORTED("not supported yet");

    private String message;

    ExceptionMessageType(String message){ this.message = message; }
    public String getValue() { return message; }
}
