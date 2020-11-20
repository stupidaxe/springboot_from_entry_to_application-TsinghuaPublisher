package com.ch.ch6_8.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_8.domain.Location;
import com.ch.ch6_8.domain.Person;
import com.ch.ch6_8.repository.PersonRepository;
@RestController
public class TestMongoDBController {
	@Autowired
	private PersonRepository personRepository;
	@RequestMapping("/save")
	public List<Person> save() {
		List<Location> locations1 = new ArrayList<Location>();
		Location loc1 = new Location("北京","2019");
		Location loc2 = new Location("上海","2018");
		locations1.add(loc1);
		locations1.add(loc2);
		
		List<Location> locations2 = new ArrayList<Location>();
		Location loc3 = new Location("广州","2017");
		Location loc4 = new Location("深圳","2016");
		locations2.add(loc3);
		locations2.add(loc4);
		
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("陈恒1", 88, "男");
		p1.setLocations(locations1);
		Person p2 = new Person("陈恒2", 99, "女");
		p2.setLocations(locations2);
		persons.add(p1);
		persons.add(p2);
		
		return personRepository.saveAll(persons);
	}
	@RequestMapping("/findByPname")
	public Person findByPname(String pname) {
		return personRepository.findByPname(pname);
	}
	@RequestMapping("/selectPersonsByPsex")
	public List<Person> selectPersonsByPsex(String psex) {
		return personRepository.selectPersonsByPsex(psex);
	}
	@RequestMapping("/updatePerson")
	public Person updatePerson(String oldPname, String newPname) {
		Person p1 = personRepository.findByPname(oldPname);
		if(p1 != null)
			p1.setPname(newPname);
		return personRepository.save(p1);
	}
	@RequestMapping("/deletePerson")
	public void updatePerson(String pname) {
		Person p1 = personRepository.findByPname(pname);
		personRepository.delete(p1);
	}
}
