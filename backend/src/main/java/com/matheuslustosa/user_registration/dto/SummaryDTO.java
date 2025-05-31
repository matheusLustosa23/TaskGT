package com.matheuslustosa.user_registration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SummaryDTO(int status , boolean success, String message, Instant timestamp, String path,String errorCode) {



    //Constructor no errorCode
    public SummaryDTO(int status , boolean success, String message, Instant timestamp, String path){
        this(status , success , message, timestamp, path, null);

    }


}
