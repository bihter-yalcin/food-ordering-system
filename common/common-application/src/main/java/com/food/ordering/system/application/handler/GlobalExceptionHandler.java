package com.food.ordering.system.application.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(Exception exception){
        log.error(exception.getMessage(),exception);
        //Do not give detail to client for error messages !!!!!!
        return ErrorDTO.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message("Unexpected error!").build();
    }


    @ResponseBody
    @ExceptionHandler(value = {ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(ValidationException validateException){
        ErrorDTO errorDTO;
        //ConstraintViolationException comes from @Valid , @NotNull etc. validation annotations
        if(validateException instanceof ConstraintViolationException){
            String violations = extractViolationsFromExceptions((ConstraintViolationException) validateException);
            log.error(violations,validateException);
            errorDTO = ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(violations).build();
        }
        else {
            String exceptionMessage = validateException.getMessage();
            log.error(exceptionMessage,validateException);
            errorDTO = ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(exceptionMessage).build();
        }
        return errorDTO;

    }

    private String extractViolationsFromExceptions(ConstraintViolationException validateException) {
       return validateException.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.joining("--"));
    }
}
