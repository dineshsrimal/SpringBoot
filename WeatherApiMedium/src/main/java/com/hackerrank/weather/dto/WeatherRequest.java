package com.hackerrank.weather.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WeatherRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Float lat;
    private Float lon;
    private String city;
    private String state;
    private List<Double> temperatures;
    
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getLon() {
		return lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Double> getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(List<Double> temperatures) {
		this.temperatures = temperatures;
	}
}
