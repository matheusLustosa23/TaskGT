package com.matheuslustosa.user_registration.controller.response;

import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.shared.PaginationDTO;
import com.matheuslustosa.user_registration.dto.shared.SummaryDTO;

import java.time.Instant;

public class ApiSuccessBuilder {
    public static <T> ApiResponseDTO<T> success(T data, int status,String message,String path, PaginationDTO pagination){

        SummaryDTO summary = new SummaryDTO(
                status,
                true,
                message,
                Instant.now(),
                path,
                null
        );


        return  new ApiResponseDTO<>(summary,data,pagination);

    }

    public static <T>ApiResponseDTO<T>success(T data, int status,String message,String path){

        SummaryDTO summary = new SummaryDTO(
                status,
                true,
                message,
                Instant.now(),
                path
        );


        return  new ApiResponseDTO<>(summary,data,null);

    }

    public static <T>ApiResponseDTO<T>success(T data, int status,String message){

        SummaryDTO summary = new SummaryDTO(
                status,
                true,
                message,
                Instant.now(),
                null,
                null
        );


        return  new ApiResponseDTO<>(summary,data,null);

    }
}
