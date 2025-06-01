package com.matheuslustosa.user_registration.controller;

public enum ErroCodesApi {


    INVALID_CREDENTIALS("AUTH_001","user or password is invalid"),
    INTERNAL_SERVER_ERROR("GEN_001","An unexpected error occurred. Contact support with error code GEN_001"),;


    private final String code;
    private final String message;

    ErroCodesApi(String code, String message){
        this.code = code;
        this.message = message;

    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
