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
        model.addAttribute("mensaje", "�Hola, Spring Boot MVC!");
        return "inicio"; // Esto corresponde al nombre de una plantilla Thymeleaf (inicio.html)
    }
    @GetMapping("/pagina1")
    public String pagina1(Model model) {
        model.addAttribute("mensaje", "�Hola, Spring Boot MVC!");
        return "pagina1"; // Esto corresponde al nombre de una plantilla Thymeleaf (inicio.html)
    }
}
