package com.hackerrank.weather.service;

import com.hackerrank.weather.dto.WeatherRequest;
import com.hackerrank.weather.model.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {
    Weather createWeather(WeatherRequest weatherRequest);

    List<Weather> getAllWeatherInfos(String sort);

    List<Weather> getWeatherByDate(Date date, String sort);

    List<Weather> getWeatherByCity(String city, String sort);

    Weather getWeatherById(Integer id) throws Exception;
}
