package com.schiphol.alpha.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class ExampleIndexControllerIT {

    private MockMvc mockMvc;

    @Before
    public final void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new ExampleIndexController())
                .setControllerAdvice(new ExceptionController())
                .build();
    }

    @Test
    public void shouldCreateASuperJokerBid() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
