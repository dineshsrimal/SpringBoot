package com.hackerrank.weather.controller;

import com.hackerrank.weather.dto.WeatherRequest;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {

    private final WeatherService weatherService;

    public WeatherApiRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> createWeather(@RequestBody WeatherRequest weatherRequest) {
        Weather weather = weatherService.createWeather(weatherRequest);
        return new ResponseEntity<>(weather, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> getWeatherInfo(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(weatherService.getWeatherById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Weather>> getWeatherInfo(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam(required = false) String city, @RequestParam(required = false) String sort) {
        if (date != null) {
            return new ResponseEntity<>(weatherService.getWeatherByDate(date, sort), HttpStatus.OK);
        }

        if (city != null) {
            return new ResponseEntity<>(weatherService.getWeatherByCity(city, sort), HttpStatus.OK);
        }


        return new ResponseEntity<>(weatherService.getAllWeatherInfos(sort), HttpStatus.OK);
    }

}
