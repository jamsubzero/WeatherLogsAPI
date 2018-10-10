package com.jamsubzero.entities;

/**
 * @author jam
 */

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WeatherLog {

	@Id
	@GeneratedValue
	private long id;
	private String responseId;
	private String location;
	private String actualWeather;
	private String temperature;
	private Timestamp dtimeInserted;
	
	public WeatherLog() {
	}

	public WeatherLog(String responseId, String location, String actualWeather, String temperature) {
		this.responseId = responseId;
		this.location = location;
		this.actualWeather = actualWeather;
		this.temperature = temperature;
	}
	
	public WeatherLog(long id, String responseId, String location, String actualWeather, String temperature,
			Timestamp dtimeInserted) {
		this.id = id;
		this.responseId = responseId;
		this.location = location;
		this.actualWeather = actualWeather;
		this.temperature = temperature;
		this.dtimeInserted = dtimeInserted;
	}
	
	public long getId() {
		return id;
	}
	public String getResponseId() {
		return responseId;
	}
	public String getLocation() {
		return location;
	}
	public String getActualWeather() {
		return actualWeather;
	}
	public String getTemperature() {
		return temperature;
	}
	public Timestamp getDtimeInserted() {
		return dtimeInserted;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setActualWeather(String actualWeather) {
		this.actualWeather = actualWeather;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public void setDtimeInserted(Timestamp dtimeInserted) {
		this.dtimeInserted = dtimeInserted;
	}
	
	
	
	

}
