package com.ch.ch7_2.entity;
import java.io.Serializable;
import java.util.List;
public class Authority implements Serializable{
	private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private List<MyUser> userList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MyUser> getUserList() {
		return userList;
	}
	public void setUserList(List<MyUser> userList) {
		this.userList = userList;
	}
}
