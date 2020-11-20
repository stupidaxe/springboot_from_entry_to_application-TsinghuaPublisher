package com.ch.ch6_7.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import com.ch.ch6_7.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{
	/**
	 * 自定义接口查询方法，暴露为REST资源
	 */
	@RestResource(path = "snameStartsWith", rel = "snameStartsWith")
	List<Student> findBySnameStartsWith(@Param("sname") String sname);
}
