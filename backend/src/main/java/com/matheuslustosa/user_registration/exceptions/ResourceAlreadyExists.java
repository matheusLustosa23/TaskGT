package com.matheuslustosa.user_registration.exceptions;

import java.io.Serial;

public class ResourceAlreadyExists extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public ResourceAlreadyExists(String message) {
        super(message);

    }
}
