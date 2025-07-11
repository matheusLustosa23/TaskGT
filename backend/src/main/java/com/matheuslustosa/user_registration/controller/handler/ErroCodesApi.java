package com.matheuslustosa.user_registration.controller.handler;

public enum ErroCodesApi {


    INVALID_CREDENTIALS("AUTH_001","Invalid username or password"),
    ACCESS_DENIED("AUTH_002","Access denied"),
    TOKEN_INVALID("AUTH_003","Token is invalid"),
    USER_NOT_FOUND_ERROR("USER_001","user not found"),
    ROLE_NOT_FOUND_ERROR("ROLE_001","role not found"),
    TASK_NOT_FOUND_ERROR("TASK_001","task not found"),
    BODY_INVALID("BODY_001","Malformed JSON in request body."),
    INTERNAL_SERVER_ERROR("GEN_001","An unexpected error occurred. Contact support with error code GEN_001"),
    RESOURCE_ALREADY_EXISTS("RESOURCE_001", "Resource already exists");



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
