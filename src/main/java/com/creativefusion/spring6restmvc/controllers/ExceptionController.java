package com.creativefusion.spring6restmvc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sm@creativefusion.net
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Void> handleNotFoundException(){
        return ResponseEntity.notFound().build();
    }
}
