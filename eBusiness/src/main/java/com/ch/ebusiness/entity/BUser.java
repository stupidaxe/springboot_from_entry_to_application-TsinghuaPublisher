package com.ch.ebusiness.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class BUser {
	private Integer id;
	@NotBlank(message="邮箱必须输入！")
	@Email(message="邮箱格式不正确！")
	private String bemail;
	@NotBlank(message="密码必须输入！")
	@Length(min=6, max=20, message="密码长度在6到20之间！")
	private String bpwd;
	private String rebpwd;
	private String code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	public String getBpwd() {
		return bpwd;
	}
	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRebpwd() {
		return rebpwd;
	}
	public void setRebpwd(String rebpwd) {
		this.rebpwd = rebpwd;
	}
}
