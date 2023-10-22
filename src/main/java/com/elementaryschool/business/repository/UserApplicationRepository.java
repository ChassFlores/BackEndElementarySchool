/**
 * 
 */
package com.elementaryschool.business.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elementaryschool.business.model.UserApplication;

/**
 * @author sebad
 *
 */
public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {

	Optional<UserApplication> findByUsername(String username);
}
