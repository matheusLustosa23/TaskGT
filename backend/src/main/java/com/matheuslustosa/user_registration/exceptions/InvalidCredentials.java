package com.matheuslustosa.user_registration.exceptions;

import java.io.Serial;

/**
 * Exception thrown when login credentials are invalid.
 */
public class InvalidCredentials extends  RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidCredentials(String message){
        super(message);
    }


}
