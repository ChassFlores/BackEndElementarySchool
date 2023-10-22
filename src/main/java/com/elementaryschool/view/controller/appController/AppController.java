/**
 * 
 */
package com.elementaryschool.view.controller.appController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sebad
 *
 */
@Controller
public class AppController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user/dashboard")
    public String userDashboard() {
        return "dashboard";
    }
    
    @GetMapping("admin/dashboard")
    public String adminDashboard() {
        return "dashboard";
    }
}