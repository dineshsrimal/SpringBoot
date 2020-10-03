package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/weather")
@AllArgsConstructor
public class WeatherApiRestController {

    private WeatherService weatherService;


    @PostMapping(consumes = "application/json")
    public ResponseEntity<Weather> createWheatherEntry(@RequestBody  Weather weather) {
        return new ResponseEntity<>(weatherService.createWheatherEntry(weather), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Weather>> getWeather(@RequestParam("city") String city, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam("sort") String sortBy) {
        return new ResponseEntity<>(weatherService.getWeather(city, date, sortBy), HttpStatus.OK);

    }


    @GetMapping(params = "date")
    public ResponseEntity<List<Weather>> getListAndDateFilter(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return new ResponseEntity<>(weatherService.getListAndDateFilter(date), HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Weather> getListAndIdFilter(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(weatherService.getListAndId(id), HttpStatus.OK);
    }



    @GetMapping(params = "sort")
    public ResponseEntity<List<Weather>> getListAndDateFilterOrderdByDated(@RequestParam("sort") String sortBy) {
        return new ResponseEntity<>(weatherService.getListAndDateFilterOrdered(sortBy), HttpStatus.OK);

    }

}
