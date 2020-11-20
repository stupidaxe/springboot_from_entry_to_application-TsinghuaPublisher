package com.ch.ch9_2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch9_2.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
