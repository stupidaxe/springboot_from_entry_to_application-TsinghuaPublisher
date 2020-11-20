package com.ch.ch6_5.repository;
import java.util.List;
import com.ch.ch6_5.entity.MyUser;
public interface MyUserRepository {
	public int saveUser(MyUser myUser);
	public int deleteUser(Integer id);
	public int updateUser(MyUser myUser);
	public List<MyUser> findAll();
	public MyUser findUserById(Integer id);
}
