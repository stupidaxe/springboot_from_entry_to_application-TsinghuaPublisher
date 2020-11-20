package com.ch.ch7_1.service;
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
import com.ch.ch7_1.entity.Authority;
import com.ch.ch7_1.entity.MyUser;
import com.ch.ch7_1.repository.MyUserRepository;
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
		List<Authority> authorityList = new ArrayList<Authority>();
		//管理员权限
		if("admin".equals(username)) {
			Authority a1 = new Authority();
			Authority a2 = new Authority();
			a1.setId(1);
			a1.setName("ROLE_ADMIN");
			a2.setId(2);
			a2.setName("ROLE_DBA");
			authorityList.add(a1);
			authorityList.add(a2);
		}else {//用户权限
			Authority a1 = new Authority();
			a1.setId(3);
			a1.setName("ROLE_USER");
			authorityList.add(a1);
		}
		userDomain.setAuthorityList(authorityList);
		//加密密码
		String secret  = new BCryptPasswordEncoder().encode(userDomain.getPassword());
		userDomain.setPassword(secret);
		MyUser mu = myUserRepository.save(userDomain);
		if(mu != null)//注册成功
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
