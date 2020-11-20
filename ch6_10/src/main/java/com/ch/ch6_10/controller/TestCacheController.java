package com.ch.ch6_10.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_10.entity.Student;
import com.ch.ch6_10.service.StudentService;
@RestController
public class TestCacheController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/savePut")
	public Student save(Student student) {
		return studentService.saveStudent(student);
	}
	@RequestMapping("/selectAble")
	public Student select(Integer id) {
		return studentService.selectOneStudent(id);
	}
	@RequestMapping("/deleteEvict")
	public String deleteCache(Student student) {
		studentService.deleteCache(student);
		return "ok";
	}
}
