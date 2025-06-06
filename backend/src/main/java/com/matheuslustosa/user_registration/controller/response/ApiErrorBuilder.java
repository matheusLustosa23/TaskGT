package com.matheuslustosa.user_registration.controller.response;

import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.shared.SummaryDTO;

import java.time.Instant;

public class ApiErrorBuilder {
    public static <T> ApiResponseDTO<T> error(String message, String errorCode, int status, String path){
        SummaryDTO summary = new SummaryDTO(
                status,
                false,
                message,
                Instant.now(),
                path,
                errorCode
        );

        return  new ApiResponseDTO<>(summary,null);

    }

}
