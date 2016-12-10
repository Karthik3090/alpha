package com.schiphol.alpha.service.impl;

import com.schiphol.alpha.service.ExampleService;
import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl implements ExampleService {

    @Override
    public String exampleMethod() {
        return "Sample!";
    }
}
