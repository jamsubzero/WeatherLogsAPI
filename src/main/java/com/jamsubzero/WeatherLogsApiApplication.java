package com.jamsubzero;

/**
 * @author jam
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jamsubzero.services.WeatherLogger;


@SpringBootApplication
public class WeatherLogsApiApplication implements CommandLineRunner{

	@Autowired
	 WeatherLogger  weatherLogger; 
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherLogsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 weatherLogger.startLogging(); 
	}
		
	
}
