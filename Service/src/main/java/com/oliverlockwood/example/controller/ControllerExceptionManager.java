package com.oliverlockwood.example.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/**
 * Class which handles the controller exceptions.
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionManager {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class, IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse badRequest(Exception exception) {

        log.debug(exception.getMessage());
        return new ExceptionResponse(exception);
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ExceptionResponse processOtherException(RuntimeException poe) {

        log.error("Internal server error", poe);
        return new ExceptionResponse(poe);
    }


    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ResponseBody
    public ExceptionResponse notImplemented(UnsupportedOperationException exception) {

        log.debug(exception.getMessage());
        return new ExceptionResponse(exception);

    }

    @Value
    public class ExceptionResponse {

        private String errorMessage;
        private String stackTrace;


        ExceptionResponse(final Throwable tw) {

            errorMessage = tw.getMessage();
            stackTrace = ExceptionUtils.getStackTrace(tw);
        }

    }

}
