package dev.buttazzopierluigi.battletohero.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(RuntimeException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
