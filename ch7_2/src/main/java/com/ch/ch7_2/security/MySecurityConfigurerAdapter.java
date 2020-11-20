package com.ch.ch7_2.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * 认证和授权处理类
 */
@Configuration
public class MySecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	//依赖注入通用的用户服务类
	@Autowired 
	private MyUserSecurityService myUserSecurityService;
	//依赖注入加密接口
	@Autowired 
	private PasswordEncoder passwordEncoder;
	//依赖注入用户认证接口
	@Autowired
	private AuthenticationProvider authenticationProvider;
	//依赖注入认证处理成功类，验证用户成功后处理不同用户跳转到不同的页面
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	/**
	 * BCryptPasswordEncoder是PasswordEncoder的接口实现
	 * 实现加密功能
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/**
	 * DaoAuthenticationProvider是AuthenticationProvider的实现
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provide = new DaoAuthenticationProvider();
		//不隐藏用户未找到异常
		provide.setHideUserNotFoundExceptions(false);
		//设置自定义认证方式，用户登录认证
		provide.setUserDetailsService(myUserSecurityService);
		//设置密码加密程序认证
		provide.setPasswordEncoder(passwordEncoder);
		return provide;
	}
	/**
	 * 用户认证
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure(AuthenticationManagerBuilder auth) ");
		//设置认证方式
		auth.authenticationProvider(authenticationProvider);
	}
	/**
	 * 请求授权
	 * 用户授权操作
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure(HttpSecurity http)");
		http.authorizeRequests()
		//首页、登录、注册页面、登录注册功能、以及静态资源过滤掉，即可任意访问
		.antMatchers("/toLogin", "/toRegister", "/", "/login", "/register", "/css/**", "/fonts/**", "/js/**").permitAll()
		//这里默认追加ROLE_，/user/**是控制器的请求匹配路径
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/admin/**").hasAnyRole("ADMIN", "DBA")
		//其他所有请求登录后才能访问
		.anyRequest().authenticated()
		.and()
		//将输入的用户名与密码和授权的进行比较
		.formLogin()
			.loginPage("/login").successHandler(myAuthenticationSuccessHandler)
			.usernameParameter("username").passwordParameter("password")
			//登录失败
			.failureUrl("/login?error")
		.and()
		//注销行为可任意访问
		.logout().permitAll()
		.and()
		//指定异常处理页面
		.exceptionHandling().accessDeniedPage("/deniedAccess");
	}
}
