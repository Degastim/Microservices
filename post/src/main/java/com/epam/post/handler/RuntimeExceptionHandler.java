package com.epam.post.handler;


import com.epam.post.exception.InvalidFieldValueException;
import com.epam.post.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ResponseMessage> handleResourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String message = e.getLocalizedMessage();
        ResponseMessage responseMessage = new ResponseMessage(message);
        return ResponseEntity.status(httpStatus).body(responseMessage);
    }

    @ExceptionHandler(InvalidFieldValueException.class)
    public final ResponseEntity<ResponseMessage> handleInvalidFieldValueException(InvalidFieldValueException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = e.getLocalizedMessage();
        ResponseMessage responseMessage = new ResponseMessage(message);
        return ResponseEntity.status(httpStatus).body(responseMessage);
    }
}
