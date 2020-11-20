package com.ch.ch6_1.service;
import java.util.List;
import com.ch.ch6_1.entity.MyUser;
public interface UserService {
	public void saveAll();
	public List<MyUser> findAll();
	public MyUser findByUname(String uname);
	public List<MyUser> findByUnameLike(String uname);
	public MyUser getOne(int id);
}
