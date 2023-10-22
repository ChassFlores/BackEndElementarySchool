/**
 * 
 */
package com.elementaryschool.view.service.userDetailsService;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elementaryschool.business.model.UserApplication;
import com.elementaryschool.business.repository.UserApplicationRepository;

/**
 * @author sebad
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserApplicationRepository userRepository;
	
	@Autowired
	public CustomUserDetailsService(UserApplicationRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApplication user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
	}

}