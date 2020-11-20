package com.ch.ch5_1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ch.ch5_1.model.LoginBean;
@Controller
public class LoginController {
	@RequestMapping("/toLogin")
	public String toLogin(Model model) {
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}
	@RequestMapping("/login")
	 public String greetingSubmit(@ModelAttribute LoginBean loginBean) {
		System.out.println("测试提交的数据：" + loginBean.getUname());
	    return "result";
	 }
}
