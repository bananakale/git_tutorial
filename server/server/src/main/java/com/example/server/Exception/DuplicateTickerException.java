package com.example.server.Exception;

public class DuplicateTickerException extends RuntimeException {
    public DuplicateTickerException(String message){
        super(message);
    }
}
