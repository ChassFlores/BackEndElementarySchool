/**
 * 
 */
package com.elementaryschool.view.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementaryschool.business.model.UserApplication;
import com.elementaryschool.business.repository.UserApplicationRepository;

/**
 * @author sebad
 *
 */
@Service
public class UserApplicationService {

	@Autowired
	private UserApplicationRepository userApplicationRepository;
	
    public void saveUser(UserApplication user) {
    	userApplicationRepository.save(user);
    }
    
    public Optional<UserApplication> findByUsername(String user) {
    	return userApplicationRepository.findByUsername(user);
    }
}
