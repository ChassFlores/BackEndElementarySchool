/**
 * 
 */
package com.elementaryschool.business.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.elementaryschool.business.model.base.Base;

/**
 * 
 */
@Entity
public class Advocate extends Base {

	@Column(nullable = false)
	private String name;
	@Column(nullable = false, length = 15, unique = true)
	private String idIdentification;
	@Column(nullable = true, length = 10)
	private String landlinePhone;
	@Column(nullable = true, length = 10)
	private String smartPhone;
	@Column(nullable = true, length = 10)
	private String officePhone;
	@Column(nullable = false)
	private String correo;
	@Column(nullable = true)
	private String profession;
	@Column(nullable = true)
	private String business;
	@Column(nullable = true)
	private String studentRelation;
	
	@OneToMany(mappedBy = "advocate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdIdentification() {
		return idIdentification;
	}

	public void setIdIdentification(String idIdentification) {
		this.idIdentification = idIdentification;
	}

	public String getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(String landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	public String getSmartPhone() {
		return smartPhone;
	}

	public void setSmartPhone(String smartPhone) {
		this.smartPhone = smartPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getStudentRelation() {
		return studentRelation;
	}

	public void setStudentRelation(String studentRelation) {
		this.studentRelation = studentRelation;
	}

}
