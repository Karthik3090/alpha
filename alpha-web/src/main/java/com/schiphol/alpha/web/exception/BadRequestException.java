package com.schiphol.alpha.web.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BadRequestException extends Exception {

    private List<String> errors;

    public BadRequestException(String message) {
        super(message);
    }

    /**
     * An exception with multiple incorrect request parameters.
     *
     * @param fieldErrors
     */
    public BadRequestException(List<FieldError> fieldErrors) {
        errors = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            errors.add(error.getField() + " " + error.getDefaultMessage());
        }
    }

}
