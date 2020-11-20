package com.ch.ch6_2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch6_2.entity.IdCard;
public interface IdCardRepository extends JpaRepository<IdCard, Integer>{
	/**
	 * 根据人员ID查询身份信息（关联查询，根据person属性的id）
	 * 相当于JPQL语句：select ic from IdCard ic where ic.person.id = ?1
	 */
	public IdCard findByPerson_id(Integer id);
	/**
	 * 根据地址和身份证号查询身份信息
	 * 相当于JPQL语句：select ic from IdCard ic where ic.address = ?1 and ic.code =?2
	 */
	public List<IdCard> findByAddressAndCode(String address, String code);
}
