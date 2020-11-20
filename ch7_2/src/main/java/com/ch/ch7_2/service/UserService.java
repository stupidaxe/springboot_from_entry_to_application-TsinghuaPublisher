package com.ch.ch7_2.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import com.ch.ch7_2.entity.MyUser;
public interface UserService {
	public String register(MyUser userDomain);
	public String loginSuccess(Model model);
	public String main(Model model);
	public String deniedAccess(Model model);
	public String logout(HttpServletRequest request, HttpServletResponse response);
}
