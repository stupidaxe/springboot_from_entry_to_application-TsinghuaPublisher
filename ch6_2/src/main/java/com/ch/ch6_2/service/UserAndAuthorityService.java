package com.ch.ch6_2.service;
import java.util.List;
import com.ch.ch6_2.entity.Authority;
import com.ch.ch6_2.entity.User;
public interface UserAndAuthorityService {
	public void saveAll();
	public List<User> findByAuthorityList_id(int id);
	public List<User> findByAuthorityList_name(String name);
	public List<Authority> findByUserList_id(int id);
	public List<Authority> findByUserList_Username(String username);
	public List<Authority> findByUserListUsername(String username);
}
