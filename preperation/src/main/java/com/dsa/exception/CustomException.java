package com.dsa.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final String errorCode;
    private final String details;

    public CustomException(String message){
        super(message);
        this.errorCode = null;
        this.details = null;
    }

    public CustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.details = null;
    }

    public CustomException(String message, String errorCode, Throwable cause) {
        super(errorCode, cause);
        this.errorCode= errorCode;
        this.details = message;
    }

}
