/**
 * 
 */
package com.elementaryschool.view.controller.appController;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elementaryschool.business.model.UserApplication;
import com.elementaryschool.business.repository.UserApplicationRepository;

/**
 * @author sebad
 *
 */
@Controller
public class AppController {
	
	@Autowired
	private UserApplicationRepository userApplicationRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model, Principal principal) {
    	Optional<UserApplication> user = userApplicationRepository.findByUsername(principal.getName());
    	boolean isAdmin = user.get().getRole().equals("ROLE_ADMIN");
    	model.addAttribute("usuario", principal.getName());
    	model.addAttribute("isAdmin", isAdmin);
        return "dashboard";
    }
   
}