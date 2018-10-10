package com.jamsubzero.services;

import java.util.UUID;

import org.jboss.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamsubzero.entities.WeatherLog;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class WeatherLogger {
	
	@Autowired
	WeatherLogService weatherService;
	
	//private final int NUMBER_OF_LOGS = 5;
	private final int NUMBER_OF_CITIES = 3;
	private final String SERVICE_ONE_URI = "http://localhost:8080/weather"; // the first service, granting both services are in the same machine
	Logger logger = Logger.getLogger(WeatherLogger.class);
	
	
	public void startLogging() throws JSONException, UnirestException {
	while(true){	
		String responseID = UUID.randomUUID().toString();
		
	    for(int index = 0; index < NUMBER_OF_CITIES; index++) {// because there are three cities
	    	
		JSONObject jsonWeather = getResponse().getJSONObject(index);
		
		String loc = jsonWeather.getString("location");
		String weath = jsonWeather.getString("weather");
		String temp = String.valueOf(jsonWeather.getDouble("temperature"));
		
		if(!weatherService.isExists(loc, weath, temp)){
		
	  	 weatherService.insert(new WeatherLog(responseID, loc, weath, temp));
		
		}else {
			logger.info("IT Exists!");
		}
		}

	}
 }
	
	private JSONArray getResponse() throws UnirestException {
		
		HttpResponse<JsonNode> response = Unirest.get(SERVICE_ONE_URI)
                .header("content-type","application/json")
                .asJson(); 
		return response.getBody().getArray();
	}
	
}
