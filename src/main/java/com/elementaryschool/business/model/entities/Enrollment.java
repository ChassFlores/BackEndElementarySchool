/**
 * 
 */
package com.elementaryschool.business.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.elementaryschool.business.model.base.Base;

/**
 * 
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "creationDate", "student_id" }) })
public class Enrollment extends Base {
	private String grade;
	private LocalDate creationDate;
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
