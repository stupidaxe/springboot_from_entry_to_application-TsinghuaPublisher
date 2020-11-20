package com.ch.ch7_1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch7_1.entity.MyUser;
public interface MyUserRepository extends JpaRepository<MyUser, Integer>{
	//根据用户名查询用户，方法名命名符合Spring Data JPA规范
	MyUser findByUsername(String username);
}
