package com.matheuslustosa.user_registration.exceptions;

import java.io.Serial;

public class RoleNotFound extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1l;

    public RoleNotFound(String message){
        super(message);
    }
}
