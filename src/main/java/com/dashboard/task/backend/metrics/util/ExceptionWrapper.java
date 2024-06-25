package com.dashboard.task.backend.metrics.util;

import com.dashboard.task.backend.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionWrapper extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return unhandledException(ex, request);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> unhandledException(Exception exception, WebRequest request) {
        log.error(exception.getMessage(), exception, Arrays.toString(exception.getStackTrace()));
        String message = exception.getMessage();

        ErrorDetails details = ErrorDetails.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(message)
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> notFoundException(NotFoundException exception, WebRequest request) {
        log.error(exception.getMessage(), exception, Arrays.toString(exception.getStackTrace()));
        String message = exception.getMessage();

        ErrorDetails details = ErrorDetails.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(message)
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

}
