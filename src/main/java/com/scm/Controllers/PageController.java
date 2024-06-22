package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home Page");
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("pageDescription", "This is the home page");
        model.addAttribute("pageUrl", "home");;
        return "home";
    }

}
