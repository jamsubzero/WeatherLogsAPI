package com.jamsubzero.services;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamsubzero.entities.WeatherLog;
import com.jamsubzero.repositiries.WeatherLogRepository;

@Service
public class WeatherLogService {

	
	@Autowired
	WeatherLogRepository weatherRepository;
	
	public void insert(WeatherLog weatherLog) {
		weatherLog.setDtimeInserted(new Timestamp(new Date().getTime()));
		weatherRepository.save(weatherLog);
	}
	
	public boolean isExists(String location, String actualWeather, String temperature) {
		Optional<WeatherLog> weatherLog= weatherRepository.findByLocationAndActualWeatherAndTemperature(location, actualWeather, temperature);
		return weatherLog.isPresent();
	}
	
	
	
	
	
	
	
	
}
