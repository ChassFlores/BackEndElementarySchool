/**
 * 
 */
package com.elementaryschool.view.controller.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sebad
 *
 */
@Controller
public class HomePageController {
    @GetMapping("/")
    public String paginaInicio(Model model) {
    	return "index"; // Esto corresponde al nombre de una plantilla Thymeleaf (inicio.html)
    }
}
