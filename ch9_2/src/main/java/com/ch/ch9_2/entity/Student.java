package com.ch.ch9_2.entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "student_table")
/**解决No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor异常*/
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;//主键
	private String sno;
	private String sname;
	private String ssex;
	public Student() {
		super();
	}
	public Student(int id, String sno, String sname, String ssex) {
		super();
		this.id = id;
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
}
