package com.ch.ch6_2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch6_2.entity.Person;
public interface PersonRepository extends JpaRepository<Person, Integer>{
	/**
	 * 根据身份ID查询人员信息（关联查询，根据idCard属性的id）
	 * 相当于JPQL语句：select p from Person p where p.idCard.id = ?1
	 */
	public Person findByIdCard_id(Integer id);
	/**
	 * 根据人名和性别查询人员信息
	 * 相当于JPQL语句：select p from Person p where p.pname = ?1 and p.psex = ?2
	 */
	public List<Person> findByPnameAndPsex(String pname, String psex);
}
