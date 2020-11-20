package com.ch.ch6_8.domain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
public class Person {
	@Id
	private String pid;
	private String pname;
	private Integer page;
	private String psex;
	@Field("plocs")
	private List<Location> locations = new ArrayList<Location>();
	public Person() {
		super();
	}
	public Person(String pname, Integer page, String psex) {
		super();
		this.pname = pname;
		this.page = page;
		this.psex = psex;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
