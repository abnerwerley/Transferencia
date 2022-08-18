package com.transferencia.itau.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MessageResponse> handleConstraintViolationException(ConstraintViolationException e) {

        MessageResponse eDetails = this.baseResponse(e, HttpStatus.BAD_REQUEST, "Constraint violations.");
        return new ResponseEntity<>(eDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<MessageResponse> handleRequestException(RequestException e) {

        MessageResponse eDetails = this.baseResponse(e, HttpStatus.BAD_REQUEST, "There is a problem with your request.");
        return new ResponseEntity<>(eDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<MessageResponse> handleNullPointerException(NullPointerException e) {

        MessageResponse eDetails = this.baseResponse(e, HttpStatus.BAD_REQUEST, "Attempt to use null in a case where an object is required.");
        return new ResponseEntity<>(eDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MessageResponse> handleNoSuchElementException(NoSuchElementException e) {

        MessageResponse eDetails = this.baseResponse(e, HttpStatus.NOT_FOUND, ".");
        return new ResponseEntity<>(eDetails, HttpStatus.NOT_FOUND);
    }

    public MessageResponse baseResponse(Exception e, HttpStatus status, String message) {
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
