package com.ch.ch6_9.entity;
import java.io.Serializable;
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sno;
	private String sname;
	private Integer sage;
	public Student() {
		super();
	}
	public Student(String sno, String sname, Integer sage) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
}
