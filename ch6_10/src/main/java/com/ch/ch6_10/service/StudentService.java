package com.ch.ch6_10.service;
import com.ch.ch6_10.entity.Student;
public interface StudentService {
	public Student saveStudent(Student student);
	public void deleteCache(Student student);
	public Student selectOneStudent(Integer id);
}
