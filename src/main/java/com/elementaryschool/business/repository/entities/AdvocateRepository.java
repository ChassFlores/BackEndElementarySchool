/**
 * 
 */
package com.elementaryschool.business.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elementaryschool.business.model.entities.Advocate;

/**
 * 
 */
@Repository
public interface AdvocateRepository extends JpaRepository<Advocate, Long> {

}
