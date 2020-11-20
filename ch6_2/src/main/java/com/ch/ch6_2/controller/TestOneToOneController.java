package com.ch.ch6_2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_2.entity.IdCard;
import com.ch.ch6_2.entity.Person;
import com.ch.ch6_2.service.PersonAndIdCardService;
@RestController
public class TestOneToOneController {
	@Autowired 
	private PersonAndIdCardService personAndIdCardService;
	@RequestMapping("/save")
	public String save() {
		personAndIdCardService.saveAll();
		return "人员和身份保存成功！";
	}
	@RequestMapping("/findAllPerson")
	public List<Person> findAllPerson() {
		return  personAndIdCardService.findAllPerson();
	}
	@RequestMapping("/findAllIdCard")
	public List<IdCard>  findAllIdCard() {
		return personAndIdCardService.findAllIdCard();
	}
	/**
	 * 根据人员ID查询身份信息（级联查询）
	 */
	@RequestMapping("/findByPerson_id")
	public IdCard findByPerson_id(Integer id) {
		return personAndIdCardService.findByPerson_id(id);
	}
	@RequestMapping("/findByAddressAndCode")
	public List<IdCard> findByAddressAndCode(String address, String code){
		return personAndIdCardService.findByAddressAndCode(address, code);
	}
	/**
	 * 根据身份ID查询人员信息（级联查询）
	 */
	@RequestMapping("/findByIdCard_id")
	public Person findByIdCard_id(Integer id) {
		return personAndIdCardService.findByIdCard_id(id);
	}
	@RequestMapping("/findByPnameAndPsex")
	public List<Person> findByPnameAndPsex(String pname, String psex) {
		return personAndIdCardService.findByPnameAndPsex(pname, psex);
	}
	@RequestMapping("/getOneIdCard")
	public IdCard getOneIdCard(Integer id) {
		return personAndIdCardService.getOneIdCard(id);
	}
	@RequestMapping("/getOnePerson")
	public Person getOnePerson(Integer id) {
		return personAndIdCardService.getOnePerson(id);
	}
}
