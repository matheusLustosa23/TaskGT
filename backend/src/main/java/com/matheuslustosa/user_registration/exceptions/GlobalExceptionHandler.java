package com.matheuslustosa.user_registration.exceptions;



import com.matheuslustosa.user_registration.controller.handler.ErroCodesApi;
import com.matheuslustosa.user_registration.controller.response.ApiErrorBuilder;
import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<?>>taskNotFoundException(TaskNotFoundException taskNotFoundException,HttpServletRequest httpServletRequest) {
        log.info("task not found exception: {}",taskNotFoundException.getMessage());
        ApiResponseDTO<?>response=ApiErrorBuilder.error(
                ErroCodesApi.TASK_NOT_FOUND_ERROR.getMessage(),
                ErroCodesApi.TASK_NOT_FOUND_ERROR.getCode(),
                HttpStatus.NOT_FOUND.value(),
                httpServletRequest.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TokenInvalidException.class)
    public ResponseEntity<ApiResponseDTO<?>>tokenInvalidException(TokenInvalidException ex,HttpServletRequest request){
        log.warn("Token is invalid: {}",ex.getMessage());
        ApiResponseDTO<?>response= ApiErrorBuilder.error(
                ErroCodesApi.TOKEN_INVALID.getMessage(),
                ErroCodesApi.TOKEN_INVALID.getCode(),
                HttpStatus.UNAUTHORIZED.value(),
                request.getRequestURI()

        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<?>>userNotFoundException(UserNotFoundException ex, HttpServletRequest request){
        log.info("User not found: {} " , ex.getMessage());
        ApiResponseDTO<?>response= ApiErrorBuilder.error(
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
        ApiResponseDTO<?>response=ApiErrorBuilder.error(
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
        ApiResponseDTO<?> response = ApiErrorBuilder.error(
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
        ApiResponseDTO<?> response = ApiErrorBuilder.error(
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
        ApiResponseDTO<?> response = ApiErrorBuilder.error(
                ErroCodesApi.ACCESS_DENIED.getMessage(),
                ErroCodesApi.ACCESS_DENIED.getCode(),
                HttpStatus.FORBIDDEN.value(),
                request.getRequestURI()


        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponseDTO<?>>httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request){
        log.warn("error , body invalid {}",ex.getMessage());
        ApiResponseDTO<?>response=ApiErrorBuilder.error(
                ErroCodesApi.BODY_INVALID.getMessage(),
                ErroCodesApi.BODY_INVALID.getCode(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



}
