package com.hackerrank.weather.service.impl;


import com.hackerrank.weather.exception.WeatherServiceNotFoundRequestException;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;


    @Override
    public Weather createWheatherEntry(Weather weather) {
        return weatherRepository.save(weather);
    }


    @Override
    public List<Weather> getListAndDateFilter(Date date) {
        Optional<List<Weather>> weatherList = weatherRepository.findByDate(date);
        return weatherList.orElseGet(ArrayList::new);
    }

    @Override
    public Weather getListAndId(Integer id) {
        return weatherRepository.findById(id).orElseThrow(WeatherServiceNotFoundRequestException::new);
    }

    @Override
    public List<Weather> getWeatherList() {
        return weatherRepository.findAll();
    }

    @Override
    public List<Weather> getListAndDateFilterOrdered(String sortBy) {

        if (sortBy.startsWith("-")) {

            return weatherRepository.findAll(Sort.by(Sort.Direction.DESC, sortBy.substring(1)));

        } else {
            return weatherRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));

        }
    }


	@Override
	public List<Weather> getListAndCityFilter(String city, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Weather> getWeather(String city, Date date, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}
}
