package com.dwolla.interview.demo.services;

import com.dwolla.interview.demo.dto.WeatherResponseDTO.ResponseDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${cityNameAPI}")
    private String weatherByName;
    
    @Value("${metricUnits}")
    private String metricUnits;
    
    @Value("${imperialUnits}")
    private String imperialUnits;
    

    @Override
    public ResponseDTO getCityWeatherByName(String name, boolean isMetric) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String url = getWeatherByNameAPI(name);
        if(isMetric)
        	url += metricUnits;
        else
        	url += imperialUnits;
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    private String getWeatherByNameAPI(String name) {
        return baseUrl + weatherByName + name;
    }

  
    
}
