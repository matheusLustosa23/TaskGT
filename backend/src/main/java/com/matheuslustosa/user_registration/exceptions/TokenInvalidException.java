package com.matheuslustosa.user_registration.exceptions;

import java.io.Serial;

public class TokenInvalidException extends RuntimeException{
    @Serial
    public static final long serialVersionUID = 1L;

    public TokenInvalidException(String message) {
        super(message);
    }
}
