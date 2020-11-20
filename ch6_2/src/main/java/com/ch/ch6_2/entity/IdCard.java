package com.ch.ch6_2.entity;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "idcard_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class IdCard implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;//自动递增的主键
	private String code;
	/**
	 * @Temporal主要是用来指明java.util.Date 或 java.util.Calendar 类型的属性具体
	 * 与数据库（date、time、timestamp）三个类型中的那一个进行映射
	 */
	@Temporal(value = TemporalType.DATE)
	private Calendar birthday;
	private String address;
	/**
	 * optional = false设置person属性值不能为null，也就是身份证必须有对应的主人。
	 * mappedBy = "idCard"与Person类中的idCard属性一致
	 */
	@OneToOne(
			optional = false, 
			fetch = FetchType.LAZY, 
			targetEntity = Person.class, 
			mappedBy = "idCard", 
			cascade = CascadeType.ALL
			)
	private Person person;//对应的人
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
