package com.ch.ch6_5.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_5.entity.MyUser;
import com.ch.ch6_5.service.MyUserService;
@RestController
public class MyUserController {
	@Autowired
	private MyUserService myUserService;
	@RequestMapping("/saveUser")
	public int saveUser(MyUser myUser) {
		return myUserService.saveUser(myUser);
	}
	@RequestMapping("/deleteUser")
	public int deleteUser(Integer id) {
		return myUserService.deleteUser(id);
	}
	@RequestMapping("/updateUser")
	public int updateUser(MyUser myUser) {
		return myUserService.updateUser(myUser);
	}
	@RequestMapping("/findAll")
	public List<MyUser> findAll(){
		return myUserService.findAll();
	}
	@RequestMapping("/findUserById")
	public MyUser findUserById(Integer id) {
		return myUserService.findUserById(id);
	}
}
