package com.schiphol.alpha.service;
import com.schiphol.alpha.service.impl.ExampleServiceImpl;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExampleServiceTest {

    @Test
    public void testExample() throws Exception {
        MatcherAssert.assertThat(new ExampleServiceImpl().exampleMethod(), is("Sample!"));
    }
}
