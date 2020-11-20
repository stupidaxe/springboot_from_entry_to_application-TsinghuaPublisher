package com.ch.ch7_2.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component
/**
 * 用户授权、认证成功处理类
 */
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	//Spring Security的重定向策略
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	/**
	 * 重写handle方法，通过RedirectStrategy重定向到指定的URL
	 */
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//根据当前认证用户的角色返回适当的URL
		String tagetURL = getTargetURL(authentication);
		//重定向到指定的URL
		redirectStrategy.sendRedirect(request, response, tagetURL);
	}
	/**
	 * 从Authentication对象中提取当前登录用户的角色，并根据其角色返回适当的URL
	 */
	protected String getTargetURL(Authentication authentication) {
		String url = "";
		//获得当前登录用户的权限（角色）集合
		Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
		List<String> roles = new ArrayList<String>();
		//将权限（角色）名称添加到List集合
		for (GrantedAuthority au : authorities) {
			roles.add(au.getAuthority());
		}
		//判断不同角色的用户跳转到不同的URL
		//这里的URL是控制器的请求匹配路径
		if(roles.contains("ROLE_USER")) {
			url = "/user/loginSuccess";
		}else if(roles.contains("ROLE_ADMIN")) {
			url = "/admin/main";
		}else {
			url = "/deniedAccess";
		}
		return url;
	}
}
