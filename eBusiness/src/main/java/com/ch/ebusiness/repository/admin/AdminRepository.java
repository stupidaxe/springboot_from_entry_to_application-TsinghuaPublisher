package com.ch.ebusiness.repository.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.ebusiness.entity.AUser;

@Mapper
public interface AdminRepository {
	List<AUser> login(AUser aUser);
}
