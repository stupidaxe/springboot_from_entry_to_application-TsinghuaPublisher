package com.ch.ch6_2.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch6_2.entity.Authority;
import com.ch.ch6_2.entity.User;
import com.ch.ch6_2.repository.AuthorityRepository;
import com.ch.ch6_2.repository.UserRepository;
@Service
public class UserAndAuthorityServiceImpl implements UserAndAuthorityService{
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public void saveAll() {
		//添加权限1
		Authority at1 = new Authority();
		at1.setName("增加");
		authorityRepository.save(at1);
		//添加权限2
		Authority at2 = new Authority();
		at2.setName("修改");
		authorityRepository.save(at2);
		//添加权限3
		Authority at3 = new Authority();
		at3.setName("删除");
		authorityRepository.save(at3);
		//添加权限4
		Authority at4 = new Authority();
		at4.setName("查询");
		authorityRepository.save(at4);
		//添加用户1
		User u1 = new User();
		u1.setUsername("陈恒1");
		u1.setPassword("123");
		ArrayList<Authority> authorityList1 = new ArrayList<Authority>();
		authorityList1.add(at1);
		authorityList1.add(at2);
		authorityList1.add(at3);
		u1.setAuthorityList(authorityList1);
		userRepository.save(u1);
		//添加用户2
		User u2 = new User();
		u2.setUsername("陈恒2");
		u2.setPassword("234");
		ArrayList<Authority> authorityList2 = new ArrayList<Authority>();
		authorityList2.add(at2);
		authorityList2.add(at3);
		authorityList2.add(at4);
		u2.setAuthorityList(authorityList2);
		userRepository.save(u2);
	}
	@Override
	public List<User> findByAuthorityList_id(int id) {
		return userRepository.findByAuthorityList_id(id);
	}
	@Override
	public List<User> findByAuthorityList_name(String name) {
		return userRepository.findByAuthorityList_name(name);
	}
	@Override
	public List<Authority> findByUserList_id(int id) {
		return authorityRepository.findByUserList_id(id);
	}
	@Override
	public List<Authority> findByUserList_Username(String username) {
		return authorityRepository.findByUserList_Username(username);
	}
	@Override
	public List<Authority> findByUserListUsername(String username) {
		return authorityRepository.findByUserListUsername(username);
	}
}
