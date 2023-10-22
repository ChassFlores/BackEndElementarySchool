/**
 * 
 */
package com.elementaryschool.business.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author sebad
 *
 */
@MappedSuperclass
public class Base {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
    
    @Version
    private Long version;
    
	private String status;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
