package com.cliente.exception;

public class ClientNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientNotFoundException(String cause) {
        super(cause);
    }
}
