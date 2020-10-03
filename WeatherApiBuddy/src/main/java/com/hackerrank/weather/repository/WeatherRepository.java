package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    Optional<List<Weather>> findByCityIgnoreCase(String city);

    Optional<List<Weather>> findByDate(Date date);

    Optional<List<Weather>> findByCityIgnoreCase(String city , Sort sort );

    Optional<List<Weather>> findByCityAndDate(String city, Date date, Sort sort);

    Optional<List<Weather>> findByCityAndDate(String city, Date date);

}
