/**
 * 
 */
package com.elementaryschool.view.controller.appController;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.elementaryschool.business.model.UserApplication;
import com.elementaryschool.exception.UserExistException;
import com.elementaryschool.utils.Status;
import com.elementaryschool.view.service.UserApplicationService;

/**
 * @author sebad
 *
 */
@Controller
public class ApplicationUserController {

    
    private final UserApplicationService service;
    
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public ApplicationUserController(PasswordEncoder passwordEncoder, UserApplicationService service) {
		this.service = service;
		this.passwordEncoder = passwordEncoder;
    	
    }

    @GetMapping("priv/user")
    public String showRegistrationForm(Model model, Principal principal) {
    	Optional<UserApplication> user = service.findByUsername(principal.getName());
    	boolean isAdmin = user.get().getRole().equals("ROLE_ADMIN");
    	model.addAttribute("usuario", principal.getName());
    	model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("user", new UserApplication());
        return "user";
    }

    @PostMapping("/user")
    public String submitRegistration(@ModelAttribute("user") UserApplication user) throws UserExistException {
    	Optional<UserApplication> userExist = service.findByUsername(user.getUsername());
    	if(userExist.isEmpty()) {
    		user.setStatus(Status.ACTIVE.getStatus());
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
            service.saveUser(user);
    	}
    	else {
    		throw new UserExistException("the user is exist");
    	}
        return "redirect:/dashboard";
    }
}
