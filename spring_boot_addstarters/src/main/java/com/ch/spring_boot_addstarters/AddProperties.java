package com.ch.spring_boot_addstarters;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix="add")
public class AddProperties {
	private Integer number1 = 1;
	private Integer number2 = 1;
	public Integer getNumber1() {
		return number1;
	}
	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}
	public Integer getNumber2() {
		return number2;
	}
	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}
}
