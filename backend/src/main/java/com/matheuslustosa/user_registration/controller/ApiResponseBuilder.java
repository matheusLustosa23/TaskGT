package com.matheuslustosa.user_registration.controller;

import com.matheuslustosa.user_registration.dto.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.PaginationResponseDTO;
import com.matheuslustosa.user_registration.dto.SummaryDTO;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public class ApiResponseBuilder {

    public static <T>ApiResponseDTO<T>success(T data, String path,String message, PaginationResponseDTO pagination){

        SummaryDTO summary = new SummaryDTO(
                HttpStatus.OK.value(),
                true,
                message,
                Instant.now(),
                path,
                null
        );


        return  new ApiResponseDTO<>(summary,data,pagination);

    }

    public static <T>ApiResponseDTO<T>success(T data, String message,String path){

        SummaryDTO summary = new SummaryDTO(
                HttpStatus.OK.value(),
                true,
                message,
                Instant.now(),
                path
        );


        return  new ApiResponseDTO<>(summary,data,null);

    }

    public static <T>ApiResponseDTO<T>success(T data, String message){

        SummaryDTO summary = new SummaryDTO(
                HttpStatus.OK.value(),
                true,
                message,
                Instant.now(),
                null,
                null
        );


        return  new ApiResponseDTO<>(summary,data,null);

    }





}
