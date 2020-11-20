package com.ch.ebusiness.repository.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ch.ebusiness.entity.BUser;

@Mapper
public interface UserAndOrderAndOutRepository {
	List<BUser> selectUserByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
	int selectAllUser();
	List<Map<String, Object>> selectCartUser(int id);
	List<Map<String, Object>> selectOrderUser(int id);
	int deleteUser(int id);
	int selectAllOrder();
	List<Map<String, Object>> selectOrderByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
}
