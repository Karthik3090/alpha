package com.schiphol.alpha.web.controllers;

import com.schiphol.alpha.persistence.entity.Driver;
import com.schiphol.alpha.web.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@Slf4j
public class ExampleIndexController {

    @RequestMapping(value = "/maps", method = GET)
    public String showIndex(Model model) throws Exception {
        return "index";
    }

    @RequestMapping(value="/", method = GET)
    public String showIndexNew() throws Exception {
        return "index_new";
    }

    @RequestMapping(value = "/test-error", method = GET)
    public String testException() throws BadRequestException {
        throw new BadRequestException("Sample of a bad request handled by the exception controller.");
    }
}
