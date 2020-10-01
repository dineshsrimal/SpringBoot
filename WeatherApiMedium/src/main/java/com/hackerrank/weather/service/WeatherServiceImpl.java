package com.hackerrank.weather.service;

import com.hackerrank.weather.dto.WeatherRequest;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Weather createWeather(WeatherRequest weatherRequest) {
        return weatherRepository.save(new Weather(weatherRequest));
    }

    @Override
    public List<Weather> getAllWeatherInfos(String sort) {
        if (sort != null) {
            Sort.Direction order = Sort.Direction.ASC;
            if (sort.contains("-")) {
                order = Sort.Direction.DESC;
                sort = sort.substring(1);
            }
            return weatherRepository.findAll(Sort.by(order, sort));
        }
        return weatherRepository.findAll();
    }

    @Override
    public List<Weather> getWeatherByDate(Date date, String sort) {
        if (sort != null) {
            Sort.Direction order = Sort.Direction.ASC;
            if (sort.contains("-")) {
                order = Sort.Direction.DESC;
                sort = sort.substring(1);

            }
            return weatherRepository.findByDate(date, Sort.by(order, sort));
        }
        return weatherRepository.findByDate(date);
    }

    @Override
    public List<Weather> getWeatherByCity(String city, String sort) {
        if (sort != null) {
            Sort.Direction order = Sort.Direction.ASC;
            if (sort.contains("-")) {
                order = Sort.Direction.DESC;
                sort = sort.substring(1);
            }
            return weatherRepository.findByCityIgnoreCase(city, Sort.by(order, sort));
        }

        return weatherRepository.findByCityIgnoreCase(city);
    }

    @Override
    public Weather getWeatherById(Integer id) throws Exception {
        Optional<Weather> data = weatherRepository.findById(id);
        if (data.isPresent()) {
            return data.get();
        } else {
            throw new Exception();
        }
    }

}
