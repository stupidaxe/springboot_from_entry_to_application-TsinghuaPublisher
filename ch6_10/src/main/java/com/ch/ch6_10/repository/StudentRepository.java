package com.ch.ch6_10.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch6_10.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
