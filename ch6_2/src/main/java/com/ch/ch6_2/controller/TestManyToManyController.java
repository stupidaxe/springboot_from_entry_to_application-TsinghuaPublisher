package com.ch.ch6_2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_2.entity.Authority;
import com.ch.ch6_2.entity.User;
import com.ch.ch6_2.service.UserAndAuthorityService;
@RestController
public class TestManyToManyController {
	@Autowired 
	private UserAndAuthorityService userAndAuthorityService;
	@RequestMapping("/saveManyToMany")
	public String save() {
		userAndAuthorityService.saveAll();
		return "权限和用户保存成功！";
	}
	@RequestMapping("/findByAuthorityList_id")
	public List<User> findByAuthorityList_id(int id) {
		return userAndAuthorityService.findByAuthorityList_id(id);
	}
	@RequestMapping("/findByAuthorityList_name")
	public List<User> findByAuthorityList_name(String name) {
		return userAndAuthorityService.findByAuthorityList_name(name);
	}
	@RequestMapping("/findByUserList_id")
	public List<Authority> findByUserList_id(int id) {
		return userAndAuthorityService.findByUserList_id(id);
	}
	@RequestMapping("/findByUserList_Username")
	public List<Authority> findByUserList_Username(String username) {
		return userAndAuthorityService.findByUserList_Username(username);
	}
	@RequestMapping("/findByUserListUsername")
	public List<Authority> findByUserListUsername(String username) {
		return userAndAuthorityService.findByUserListUsername(username);
	}
}
