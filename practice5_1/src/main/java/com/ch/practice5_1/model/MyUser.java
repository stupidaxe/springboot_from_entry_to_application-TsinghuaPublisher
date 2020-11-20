package com.ch.practice5_1.model;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
public class MyUser {
	@NotBlank(message="用户名必须输入")
	@Length(min=5, max=20, message="用户名长度在5到20之间")
	private String uname;
	@Range(min=18,max=60,message="年龄在18到60之间")
	private Integer age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="工作日期在系统时间之前")
	private Date workdate;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getWorkdate() {
		return workdate;
	}
	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}
}
