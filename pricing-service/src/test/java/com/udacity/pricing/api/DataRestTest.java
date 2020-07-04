package com.udacity.pricing.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataRestTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getPrice() throws Exception {
        mvc.perform(get(new URI("/prices/1")).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("currency", is("USD")))
                .andExpect(jsonPath("price", is(1100.5)))
                .andExpect(jsonPath("vehicleId", is(1)));
    }
}
