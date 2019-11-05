package com.example.springboot12th.controller;

import com.example.springboot12th.exception.UnprocessableException;
import com.example.springboot12th.response.MessageInfo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(UnprocessableException.class)
    @ResponseBody
    public ResponseEntity handleUnprocessable(UnprocessableException e){
        String message = e.getMessage();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage(message);
        messageInfo.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messageInfo);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException e){
        String message = e.getMessage();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage(message);
        messageInfo.setStatus(HttpStatus.CONFLICT.value());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(messageInfo);
    }
}
