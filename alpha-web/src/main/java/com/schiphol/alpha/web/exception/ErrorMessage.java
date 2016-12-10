package com.schiphol.alpha.web.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ErrorMessage {

    private List<String> errors;

    public ErrorMessage(List<String> errors) {
        this.errors = errors;
    }

    public ErrorMessage(String error) {
        this(Collections.singletonList(error));
    }

    public ErrorMessage(String... errors) {
        this(Arrays.asList(errors));
    }

    public final List<String> getErrors() {
        return errors;
    }

    public final void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
