package com.elementaryschool.business.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elementaryschool.business.model.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
