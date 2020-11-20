package com.ch.ch6_9.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_9.entity.Student;
import com.ch.ch6_9.repository.StudentRepository;
@RestController
public class TestRedisController {
	@Autowired
	private StudentRepository studentRepository;
	@RequestMapping("/save")
	public void save() {
		studentRepository.saveString("uname", "陈恒");
		Student s1 = new Student("111","陈恒1",77);
		studentRepository.saveStudent(s1);
		Student s2 = new Student("222","陈恒2",88);
		Student s3 = new Student("333","陈恒3",99);
		List<Student>  stus = new ArrayList<Student>();
		stus.add(s2);
		stus.add(s3);
		studentRepository.saveMultiStudents("mutilStus",stus);
	}
	@RequestMapping("/getUname")
	@Cacheable(value = "myuname")
	public String getUname(String key) {
		System.out.println("测试缓存");
		return studentRepository.getString(key);
	}
	@RequestMapping("/getStudent")
	public Student getStudent(String key) {
		return (Student)studentRepository.getObject(key);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/getMultiStus")
	public List<Student> getMultiStus(String key) {
		return (List<Student>)studentRepository.getObject(key);
	}
}
