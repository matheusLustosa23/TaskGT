package com.matheuslustosa.user_registration.exceptions;

import java.io.Serial;

public class RoleNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public RoleNotFoundException(String message){
        super(message);
    }
}
