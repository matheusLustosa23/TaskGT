package com.matheuslustosa.user_registration.exceptions;


import com.matheuslustosa.user_registration.controller.ApiResponseBuilder;
import com.matheuslustosa.user_registration.controller.ErroCodesApi;
import com.matheuslustosa.user_registration.dto.ApiResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO<?>> handleGenericException(Exception ex , HttpServletRequest request){
        log.error("Unexpected error occurred", ex);
        ApiResponseDTO<?> response = ApiResponseBuilder.error(
                ErroCodesApi.INTERNAL_SERVER_ERROR.getMessage(),
                ErroCodesApi.INTERNAL_SERVER_ERROR.getCode(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<ApiResponseDTO<?>>invalidCredentials(InvalidCredentials ex, HttpServletRequest request){
        log.warn("Invalid credentials received: {}", ex.getMessage());
        ApiResponseDTO<?> response = ApiResponseBuilder.error(
                ErroCodesApi.INVALID_CREDENTIALS.getMessage(),
                ErroCodesApi.INVALID_CREDENTIALS.getCode(),
                HttpStatus.UNAUTHORIZED.value(),
                request.getRequestURI()
        );


        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

    }

}
