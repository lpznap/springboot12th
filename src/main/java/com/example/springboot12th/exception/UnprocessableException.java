package com.example.springboot12th.exception;

public class UnprocessableException extends RuntimeException{
    public UnprocessableException(String message) {
        super(message);
    }
}
