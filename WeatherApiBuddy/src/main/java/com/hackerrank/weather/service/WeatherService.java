package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {

    Weather createWheatherEntry(Weather weather);

    List<Weather> getListAndCityFilter(String city, String sortBy);

    List<Weather> getListAndDateFilter(Date date);

    Weather getListAndId(Integer id);

    List<Weather> getWeatherList();

    List<Weather> getListAndDateFilterOrdered(String sortBy);

    List<Weather> getWeather(String city, Date date, String sortBy);
}
