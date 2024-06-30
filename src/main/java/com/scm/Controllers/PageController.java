package com.scm.Controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page handler");
        // sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
        model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
        return "home";
    }

    // about route

    @RequestMapping("/about")
    public String aboutPage(Model model)
    {
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        return "about";
    }

    // services

    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("services page loading");
        return "services";
    }

    // contact page

    @GetMapping("/contact")
    public String contact()
    {
        return new String("contact");
    }

    @GetMapping("/login")
    public String login()
    {
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";

    }

    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm)
    {
//        User user = User.builder().name(userForm.getName()).email(userForm.getEmail()).password(userForm.getPassword())
//                .about(userForm.getAbout()).phoneNumber(userForm.getPhoneNumber()).profilePic("https://media.licdn.com/dms/image/D5603AQEPrpgpdcBVqA/profile-displayphoto-shrink_200_200/0/1698586118207?e=2147483647&v=beta&t=MHTBzy8KgeVXm-Yfg_dAoh4fb1ABVtpBgnJET4vJQnM").build();
        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        user.setEmail(userForm.getEmail());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://media.licdn.com/dms/image/D5603AQEPrpgpdcBVqA/profile-displayphoto-shrink_200_200/0/1698586118207?e=2147483647&v=beta&t=MHTBzy8KgeVXm-Yfg_dAoh4fb1ABVtpBgnJET4vJQnM");
       System.out.println(user);
        User saveduser =  userService.saveUser(user);
        return "redirect:/register";
    }

}