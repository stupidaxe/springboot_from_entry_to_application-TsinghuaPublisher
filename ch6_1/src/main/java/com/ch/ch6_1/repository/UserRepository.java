package com.ch.ch6_1.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch6_1.entity.MyUser;
/**
 * 这里不需要使用@Repository注解数据访问层，
 * 因为Spring Boot自动配置了JpaRepository
 */
public interface UserRepository extends JpaRepository<MyUser, Integer>{
	public MyUser findByUname(String uname);
	public List<MyUser> findByUnameLike(String uname);
}
