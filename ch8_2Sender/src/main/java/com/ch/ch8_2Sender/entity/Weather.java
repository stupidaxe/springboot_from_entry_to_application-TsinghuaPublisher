package com.ch.ch8_2Sender.entity;
import java.io.Serializable;
public class Weather implements Serializable{
	private static final long serialVersionUID = -8221467966772683998L;
	private String id;
	private String city;
	private String weatherDetail;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeatherDetail() {
		return weatherDetail;
	}
	public void setWeatherDetail(String weatherDetail) {
		this.weatherDetail = weatherDetail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", weatherDetail=" + weatherDetail + "]";
	}
}
