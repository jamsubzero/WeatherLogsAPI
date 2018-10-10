package com.jamsubzero.repositiries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jamsubzero.entities.WeatherLog;

@Repository
public interface WeatherLogRepository extends JpaRepository<WeatherLog, Long> {

//	Optional<WeatherLog> findByLocationAndActualWeatherAndTemperature(String location, String actualWeather, String temperature);
	
	@Query("select p from WeatherLog p where p.location = :location and p.actualWeather = :actualWeather and p.temperature = :temperature")
	Optional<WeatherLog> findByLocationAndActualWeatherAndTemperature(@Param("location") String location,
	                             @Param("actualWeather") String actualWeather,
	                             @Param("temperature") String temperature
			);
	
}
