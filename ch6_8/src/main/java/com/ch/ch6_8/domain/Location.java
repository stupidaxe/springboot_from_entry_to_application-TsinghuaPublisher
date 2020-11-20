package com.ch.ch6_8.domain;
public class Location {
	private String locName;
	private String year;
	public Location() {
		super();
	}
	public Location(String locName, String year) {
		super();
		this.locName = locName;
		this.year = year;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
