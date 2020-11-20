package com.ch.ch6_2.service;
import java.util.List;
import com.ch.ch6_2.entity.IdCard;
import com.ch.ch6_2.entity.Person;
public interface PersonAndIdCardService {
	public void saveAll();
	public List<Person> findAllPerson();
	public List<IdCard> findAllIdCard();
	public IdCard findByPerson_id(Integer id);
	public List<IdCard> findByAddressAndCode(String address, String code);
	public Person findByIdCard_id(Integer id);
	public List<Person> findByPnameAndPsex(String pname, String psex);
	public IdCard getOneIdCard(Integer id);
	public Person getOnePerson(Integer id);
}
