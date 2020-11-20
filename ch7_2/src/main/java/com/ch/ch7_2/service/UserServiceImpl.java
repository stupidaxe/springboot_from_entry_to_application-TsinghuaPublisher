package com.ch.ch7_2.service;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ch.ch7_2.entity.MyUser;
import com.ch.ch7_2.repository.MyUserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private MyUserRepository myUserRepository;
	/**
	 * 实现注册
	 */
	@Override
	public String register(MyUser userDomain) {
		String username = userDomain.getUsername();
		//加密密码
		String secret  = new BCryptPasswordEncoder().encode(userDomain.getPassword());
		userDomain.setPassword(secret);
		int n = myUserRepository.save(userDomain);
		//管理员权限
		if("admin".equals(username)) {
			myUserRepository.saveUserAuthority(userDomain.getId(), 1);
			myUserRepository.saveUserAuthority(userDomain.getId(), 2);
		}else {//用户权限
			myUserRepository.saveUserAuthority(userDomain.getId(), 3);
		}
		if(n != 0)//注册成功
			return "/login";
		return "/register";//注册失败
	}
	/**
	 * 用户登录成功
	 */
	@Override
	public String loginSuccess(Model model) {
		model.addAttribute("user", getUname());
		model.addAttribute("role", getAuthorities());
		return "/user/loginSuccess";
	}
	/**
	 * 管理员登录成功
	 */
	@Override
	public String main(Model model) {
		model.addAttribute("user", getUname());
		model.addAttribute("role", getAuthorities());
		return "/admin/main";
	}
	/**
	 * 注销用户
	 */
	@Override
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		//获得用户认证信息
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			//注销
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login?logout";
	}
	/**
	 * 没有权限拒绝访问
	 */
	@Override
	public String deniedAccess(Model model) {
		model.addAttribute("user", getUname());
		model.addAttribute("role", getAuthorities());
		return "deniedAccess";
	}
	/**
	 * 获得当前用户名称
	 */
	private String getUname() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	/**
	 * 获得当前用户权限
	 */
	private String getAuthorities() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		return roles.toString();
	}
}
