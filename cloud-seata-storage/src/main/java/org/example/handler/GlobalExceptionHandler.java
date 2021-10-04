package org.example.handler;

import org.example.model.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public CommonResult blockException(Exception e) {
        return new CommonResult(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage());
    }

}
