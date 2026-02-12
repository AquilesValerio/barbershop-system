package com.barbershop.barbershop.api.exceptions;

import com.barbershop.barbershop.api.exceptions.services.BadRequestException;
import com.barbershop.barbershop.api.exceptions.services.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request){
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationDTO(MethodArgumentNotValidException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<FieldError> fieldErrors = e.getFieldErrors();
        e.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        for(FieldError fieldError:e.getBindingResult().getFieldErrors()){
            errors.add(String.valueOf(fieldError));
        }

        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setErrors(errors);
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

}
