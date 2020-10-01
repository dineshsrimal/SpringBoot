package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findByDate(Date date);

    List<Weather> findByDate(Date date, Sort sort);

    List<Weather> findByCityIgnoreCase(String city);

    List<Weather> findByCityIgnoreCase(String city, Sort sort);
}
