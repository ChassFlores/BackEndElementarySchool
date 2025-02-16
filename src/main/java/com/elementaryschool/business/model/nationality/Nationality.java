/**
 * 
 */
package com.elementaryschool.business.model.nationality;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.elementaryschool.business.model.base.Base;
import com.elementaryschool.utils.Status;

/**
 * 
 */
@Entity
@Table(name = "nationality")
public class Nationality extends Base {

	private String natName;

	public Nationality(String natName) {
		super();
		this.setStatus(Status.ACTIVE.getStatus());
		this.natName = natName;
	}

	public String getNatName() {
		return natName;
	}

	public void setNatName(String natName) {
		this.natName = natName;
	}
}
