/**
 * 
 */
package com.elementaryschool.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elementaryschool.business.model.nationality.Nationality;

/**
 * 
 */
public interface NationalityRepository extends JpaRepository<Nationality, Long>{
	

}
