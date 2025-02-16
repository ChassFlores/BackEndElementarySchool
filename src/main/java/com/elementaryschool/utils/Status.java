/**
 * 
 */
package com.elementaryschool.utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sebad
 *
 */
public class Status implements InterfaceStatus {
	
	public static Status ACTIVE = new Status("ACTIVE");
	public static Status DISABLED = new Status("DISABLED");
	public static Status REMOVE = new Status("REMOVE");

	private Long ID;
	
	private String status;
	
	public Status() {}
	
	public Status(String status) {
		this.status = status;
	}
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
	@Override
	public void setStatus(String status) {
		this.status = status;

	}

	@Override
	public String getStatus() {
		return status;
	}

}
