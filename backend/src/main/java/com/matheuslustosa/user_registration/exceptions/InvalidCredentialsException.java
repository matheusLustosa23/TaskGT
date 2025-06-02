package com.matheuslustosa.user_registration.exceptions;

import java.io.Serial;

/**
 * Exception thrown when login credentials are invalid.
 */
public class InvalidCredentialsException extends  RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidCredentialsException(String message){
        super(message);
    }


}
