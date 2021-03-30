package com.dwolla.interview.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@SpringBootTest
public class WeatherControllerTest {

    @Autowired
    private WeatherController weatherController;

    private static String validCityName = "New York";

    private static String invalidCityName = "abc";

    private static boolean isMetric = true;


    @Test
    public void getCityWeatherSuccessTest(){

        ResponseEntity response = this.weatherController.getCityWeather(validCityName, isMetric);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void getCityWeatherFailTest(){

        ResponseEntity response = this.weatherController.getCityWeather(invalidCityName, isMetric);
        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }
    
    @Test
    public void getCityTemperatureSuccessTest(){

        ResponseEntity response = this.weatherController.getCityTemperature(validCityName, isMetric);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void getCityTemperatureFailTest(){

        ResponseEntity response = this.weatherController.getCityTemperature(invalidCityName, isMetric);
        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

}
