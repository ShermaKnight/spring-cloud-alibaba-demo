package org.example.handler;

import org.example.model.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    public CommonResult serviceException(ServiceException e) {
        return new CommonResult(e.getCode(), e.getMessage());
    }

}
