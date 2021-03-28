package com.assignment.spring.infrastructure;

import com.assignment.spring.http.dto.WeatherDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerIT {

    private static final String CITY = "Bucharest";
    private static final String RO = "RO";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldProcessCityWeather() throws Exception {

        MvcResult mockMvcResult =  mockMvc.perform(get("/weather?city={city}",
                CITY))
                .andExpect(status().isOk())
                .andReturn();
        byte[] content = mockMvcResult.getResponse().getContentAsByteArray();
        WeatherDTO weatherDTO = objectMapper.readValue(content, WeatherDTO.class);
        assertEquals(CITY, weatherDTO.getCity());
        assertEquals(RO, weatherDTO.getCountry());
        assertNotNull(weatherDTO.getTemperature());
    }
}
