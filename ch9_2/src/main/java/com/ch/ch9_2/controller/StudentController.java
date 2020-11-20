package com.ch.ch9_2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch9_2.entity.Student;
import com.ch.ch9_2.repository.StudentRepository;
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	/**
	 * 保存学生信息
	 */
	@PostMapping("/save")
	public String save(@RequestBody Student student) {
		studentRepository.save(student);
		return "success";
	}
	/**
	 * 根据id查询学生信息
	 */
	@GetMapping("/getOne/{id}")
	public Student getOne(@PathVariable("id") int id){
		return studentRepository.getOne(id);
	}
}
