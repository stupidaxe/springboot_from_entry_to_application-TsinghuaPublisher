package com.ch.ch7_2.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ch.ch7_2.entity.Authority;
import com.ch.ch7_2.entity.MyUser;
@Mapper
public interface MyUserRepository{
	/**
	 * 根据用户名查询用户信息
	 */
	MyUser findByUsername(String username);
	/**
	 * 根据用户id查询用户的所有权限
	 */
	List<Authority> findRoleByUser(Integer id);
	/**
	 * 注册用户
	 */
	int save(MyUser mu);
	/**
	 * 保存用户权限
	 */
	int saveUserAuthority(@Param("user_id") Integer user_id, @Param("authority_id") Integer authority_id);
}
