package com.ch.spring_boot_mystarters;
public class MyService {
	private String msg;
	public String sayMsg() {
		return "my " + msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
