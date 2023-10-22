/**
 * 
 */
package com.elementaryschool.business.model;

import javax.persistence.Entity;

import com.elementaryschool.business.model.base.Base;

/**
 * @author sebad
 *
 */
@Entity
public class UserApplication extends Base {

	private String username;

	private String password;

	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
