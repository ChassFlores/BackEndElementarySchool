/**
 * 
 */
package com.elementaryschool.business.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.elementaryschool.business.model.UserApplication;
import com.elementaryschool.business.model.nationality.Nationality;
import com.elementaryschool.business.repository.NationalityRepository;
import com.elementaryschool.business.repository.UserApplicationRepository;
import com.elementaryschool.utils.Status;

/**
 * 
 */
@Component
public class DefaultDataInitializeComponent {
	private final Logger log = LoggerFactory.getLogger(DefaultDataInitializeComponent.class.getName());
	@Bean
	public CommandLineRunner setupDefaultUser(UserApplicationRepository userRepository,
			PasswordEncoder passwordEncoder) {
		return args -> {
			if (!userRepository.findByUsername("admin").isPresent()) {
				UserApplication admin = new UserApplication();
				admin.setUsername("admin");
				admin.setStatus(Status.ACTIVE.getStatus());
				admin.setPassword(passwordEncoder.encode("m"));
				admin.setRole("ROLE_ADMIN");
				userRepository.save(admin);
				log.info("Create user: " + admin);
			}
			if (!userRepository.findByUsername("user").isPresent()) {
				UserApplication user = new UserApplication();
				user.setUsername("user");
				user.setStatus(Status.ACTIVE.getStatus());
				user.setPassword(passwordEncoder.encode("m"));
				user.setRole("ROLE_USER");
				userRepository.save(user);
				log.info("Create user: " + user);
			}
		};
	}
	@Bean
	public CommandLineRunner setupDefaultNationality(NationalityRepository repo) {
		return args -> {
			if (repo.count() == 0) { // Verifica si la tabla está vacía
				repo.saveAll(Arrays.asList(
                        new Nationality("Ecuatoriana"),
                        new Nationality("Colombiana"),
                        new Nationality("Peruana"),
                        new Nationality("Chilena"),
                        new Nationality("Argentina"),
                        new Nationality("Boliviana"),
                        new Nationality("Paraguaya"),
                        new Nationality("Uruguaya"),
                        new Nationality("Brasileña"),
                        new Nationality("Venezolana"),
                        new Nationality("Panameña"),
                        new Nationality("Costarricense"),
                        new Nationality("Cubana"),
                        new Nationality("Dominicana"),
                        new Nationality("Mexicana"),
                        new Nationality("Guatemalteca"),
                        new Nationality("Hondureña"),
                        new Nationality("Salvadoreña"),
                        new Nationality("Nicaragüense"),
                        new Nationality("Puertorriqueña"),
                        new Nationality("Española"),
                        new Nationality("Italiana"),
                        new Nationality("Francesa"),
                        new Nationality("Alemana"),
                        new Nationality("Canadiense"),
                        new Nationality("Estadounidense"),
                        new Nationality("Japonesa"),
                        new Nationality("China"),
                        new Nationality("India"),
                        new Nationality("Rusa")
                ));
                log.info("Nationalities initialized successfully.");
            } else {
            	log.info("Nationalities already exist, skipping initialization.");
            }
		};
	}
}
