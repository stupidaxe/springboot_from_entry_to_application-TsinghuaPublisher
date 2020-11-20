package com.ch.ch6_6.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.ch6_6.entity.MyUser;
/**
 * MyBatis的Mapper映射接口
 */
@Mapper
public interface MyUserRepository {
	public List<MyUser> findAll();
}