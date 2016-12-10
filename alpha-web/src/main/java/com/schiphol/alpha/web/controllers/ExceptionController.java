package com.schiphol.alpha.web.controllers;

import com.schiphol.alpha.web.exception.ErrorMessage;
import com.schiphol.alpha.web.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ErrorMessage handleBadRequest(final BadRequestException badRequestException) {
        if (badRequestException.getErrors() != null && badRequestException.getErrors().size() > 0) {
            return new ErrorMessage(badRequestException.getErrors());
        }
       ErrorMessage errorMessage = new ErrorMessage(badRequestException.getMessage());
        return errorMessage;
    }

}
