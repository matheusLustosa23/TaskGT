package com.matheuslustosa.user_registration.controller.response;

import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.shared.PaginationDTO;
import com.matheuslustosa.user_registration.dto.shared.PaginationReponseDTO;
import com.matheuslustosa.user_registration.dto.shared.SummaryDTO;
import org.springframework.data.domain.Page;

import java.time.Instant;

public class ApiSuccessBuilder {
    public static <T> ApiResponseDTO<PaginationReponseDTO<T>> success( Page<T> pagination,int status, String message, String path){
        PaginationReponseDTO<T>paginationReponseDTO = new PaginationReponseDTO<>(
                pagination.getContent(),
                new PaginationDTO(pagination)
        );
        SummaryDTO summary = new SummaryDTO(
                status,
                true,
                message,
                Instant.now(),
                path,
                null
        );


        return  new ApiResponseDTO<>(summary,paginationReponseDTO);

    }

    public static <T>ApiResponseDTO<T>success(T data, int status,String message,String path){

        SummaryDTO summary = new SummaryDTO(
                status,
                true,
                message,
                Instant.now(),
                path
        );


        return  new ApiResponseDTO<>(summary,data);

    }

    public static <T>ApiResponseDTO<T>success(int status,String message,String path){

        SummaryDTO summary = new SummaryDTO(
                status,
                true,
                message,
                Instant.now(),
                null,
                null
        );


        return  new ApiResponseDTO<>(summary,null);

    }
}
