package com.ch.ch6_8.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.ch.ch6_8.domain.Person;
public interface PersonRepository extends MongoRepository<Person, String>{
	Person findByPname(String pname);//支持方法名查询，方法名命名规范参照表6.1
	@Query("{'psex':?0}")//JSON字符串
	List<Person> selectPersonsByPsex(String psex);
}
