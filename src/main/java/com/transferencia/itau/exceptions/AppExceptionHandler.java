package com.transferencia.itau.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {

        MessageResponse eDetails = this.baseResponse(e, HttpStatus.BAD_REQUEST, "Constraint violations.");
        return new ResponseEntity<>(eDetails, HttpStatus.BAD_REQUEST);
    }

    public MessageResponse baseResponse (Exception e, HttpStatus status, String message){
        return MessageResponse.MessageResponseBuilder
                .newBuilder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .title(message)
                .detail(e.getMessage())
                .message(e.getClass().getName())
                .build();
    }
}
