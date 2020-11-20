package com.ch.spring_boot_mystarters;
import org.springframework.boot.context.properties.ConfigurationProperties;
//在application.properties中通过my.msg=设置属性
@ConfigurationProperties(prefix="my")
public class MyProperties {
	private String msg = "默认值";
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
