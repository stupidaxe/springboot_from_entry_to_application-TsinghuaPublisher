package com.ch.ch7_1.security;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ch.ch7_1.entity.Authority;
import com.ch.ch7_1.entity.MyUser;
import com.ch.ch7_1.repository.MyUserRepository;
/**
 * 获得对应的UserDetails，保存与认证相关的信息
 */
@Service
public class MyUserSecurityService implements UserDetailsService{
	@Autowired
	private MyUserRepository myUserRepository;
	/**
	 * 通过重写loadUserByUsername方法查询对应的用户
	 * UserDetails是Spring Security的一个核心接口
	 * UserDetails定义了可以获取用户名、密码、权限等与认证相关信息的方法
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//根据用户名（页面接收的用户名）查询当前用户
		MyUser myUser = myUserRepository.findByUsername(username);
		if(myUser == null) {
			throw new UsernameNotFoundException("用户名不存在");
		} 
		//GrantedAuthority代表赋予当前用户的权限（认证权限）
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//获得当前用户权限集合
		List<Authority> roles = myUser.getAuthorityList();
		
		//将当前用户的权限保存为用户的认证权限
		for (Authority authority : roles) {
			GrantedAuthority sg = new SimpleGrantedAuthority(authority.getName());
			authorities.add(sg);
		}
		//org.springframework.security.core.userdetails.User是Spring Security的内部实现，
		//专门用于保存用户名、密码、权限等与认证相关的信息
		User su = new User(myUser.getUsername(), myUser.getPassword(), authorities);
		return su;
	}
}
