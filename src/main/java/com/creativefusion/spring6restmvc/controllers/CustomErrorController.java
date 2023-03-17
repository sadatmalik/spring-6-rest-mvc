package com.creativefusion.spring6restmvc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * @author sm@creativefusion.net
 */
@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List<FieldError>> handleBindErrors(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest()
                             .body(exception.getBindingResult()
                                            .getFieldErrors());
    }
}
