/**
 * 
 */
package com.elementaryschool.view.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.elementaryschool.business.model.UserApplication;
import com.elementaryschool.business.repository.UserApplicationRepository;
import com.elementaryschool.utils.Status;
import com.elementaryschool.view.service.userDetailsService.CustomUserDetailsService;

/**
 * @author sebad
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final CustomUserDetailsService userDetailsService;

	@Autowired
	public SecurityConfig(PasswordEncoder passwordEncoder, CustomUserDetailsService userDetailsService) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/logo/**", "/images/**", "/resources/**").permitAll()
				.antMatchers("/priv/**").hasRole("ADMIN").antMatchers("/all/**").hasRole("USER")
				.antMatchers("/index", "/resources/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/index").successHandler(successHandler()).permitAll().and().logout().permitAll();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				response.sendRedirect("/dashboard");
			}
		};
	}
}
