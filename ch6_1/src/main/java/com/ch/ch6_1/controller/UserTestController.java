package com.ch.ch6_1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ch.ch6_1.service.UserService;
@Controller
public class UserTestController {
	@Autowired
	private UserService userService;
	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		userService.saveAll();
		return "保存用户成功！";
	}
	@RequestMapping("/findByUname")
	public String findByUname(String uname, Model model) {
		model.addAttribute("title", "根据用户名查询一个用户");
		model.addAttribute("auser", userService.findByUname(uname));
		return "showAuser";
	}
	@RequestMapping("/getOne")
	public String getOne(int id, Model model) {
		model.addAttribute("title", "根据用户id查询一个用户");
		model.addAttribute("auser",userService.getOne(id));
		return "showAuser";
	}
	@RequestMapping("/findAll")
	public String findAll(Model model){
		model.addAttribute("title", "查询所有用户");
		model.addAttribute("allUsers",userService.findAll());
		return "showAll";
	}
	@RequestMapping("/findByUnameLike")
	public String findByUnameLike(String uname, Model model){
		model.addAttribute("title", "根据用户名模糊查询所有用户");
		model.addAttribute("allUsers",userService.findByUnameLike(uname));
		return "showAll";
	}
}
