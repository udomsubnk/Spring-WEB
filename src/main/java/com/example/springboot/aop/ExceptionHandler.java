package com.example.springboot.aop;

import com.example.springboot.exception.UnprocessableException;
import com.example.springboot.response.MessageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<MessageInfo> handleException(UnprocessableException e) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage(e.getMessage());
        messageInfo.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messageInfo);
    }
}
