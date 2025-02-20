/**
 * 
 */
package com.elementaryschool.business.model.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.elementaryschool.business.model.base.Base;

/**
 * 
 */
@Entity
public class Student extends Base {
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String birthPlace;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(nullable = false, length = 15, unique = true)
	private String idIdentification;
	@Column(nullable = false)
	private String nationality;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String electricCode;
	@Column(nullable = true)
	private String nameSchoolFrom;
	@ManyToOne
	@JoinColumn(name = "advocate_id", nullable = false)
	private Advocate advocate;
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Enrollment> enrollements;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdIdentification() {
		return idIdentification;
	}

	public void setIdIdentificationStudent(String idIdentification) {
		this.idIdentification = idIdentification;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getElectricCode() {
		return electricCode;
	}

	public void setElectricCode(String electricCode) {
		this.electricCode = electricCode;
	}

	public String getNameSchoolFrom() {
		return nameSchoolFrom;
	}

	public void setNameSchoolFrom(String nameSchoolFrom) {
		this.nameSchoolFrom = nameSchoolFrom;
	}

	public List<Enrollment> getEnrollements() {
		return enrollements;
	}

	public void setEnrollements(List<Enrollment> enrollements) {
		this.enrollements = enrollements;
	}

}
