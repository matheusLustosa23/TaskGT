package com.matheuslustosa.user_registration.exceptions;


import com.matheuslustosa.user_registration.controller.ApiResponseBuilder;
import com.matheuslustosa.user_registration.controller.ErroCodesApi;
import com.matheuslustosa.user_registration.dto.ApiResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<?>>userNotFoundException(UserNotFoundException ex, HttpServletRequest request){
        log.info("User not found: {} " , ex.getMessage());
        ApiResponseDTO<?>response=ApiResponseBuilder.error(
                ErroCodesApi.USER_NOT_FOUND_ERROR.getMessage(),
                ErroCodesApi.USER_NOT_FOUND_ERROR.getCode(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI()

        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<?>>roleNotFoundException(RoleNotFoundException ex, HttpServletRequest request){
        log.info("Role not found: {} " , ex.getMessage());
        ApiResponseDTO<?>response=ApiResponseBuilder.error(
                ErroCodesApi.ROLE_NOT_FOUND_ERROR.getMessage(),
                ErroCodesApi.ROLE_NOT_FOUND_ERROR.getCode(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI()

        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }




    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponseDTO<?>>invalidCredentialsException(InvalidCredentialsException ex, HttpServletRequest request){
        log.warn("Invalid credentials received: {}", ex.getMessage());
        ApiResponseDTO<?> response = ApiResponseBuilder.error(
                ErroCodesApi.INVALID_CREDENTIALS.getMessage(),
                ErroCodesApi.INVALID_CREDENTIALS.getCode(),
                HttpStatus.UNAUTHORIZED.value(),
                request.getRequestURI()
        );


        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

    }


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

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponseDTO<?>>AuthorizationDeniedException(AccessDeniedException ex, HttpServletRequest request){
        log.warn("Authorization denied: {}", ex.getMessage());
        ApiResponseDTO<?> response = ApiResponseBuilder.error(
                ErroCodesApi.ACCESS_DENIED.getMessage(),
                ErroCodesApi.ACCESS_DENIED.getCode(),
                HttpStatus.FORBIDDEN.value(),
                request.getRequestURI()


        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }



}
