package com.ocm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ocm.entites.User;
import com.ocm.forms.UserForm;
import com.ocm.helpers.Message;
import com.ocm.helpers.MessageType;
import com.ocm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");

        // to send data to view in the browser i.e. answer to the request made
        model.addAttribute("name", "Nimish Bhalerao");
        model.addAttribute("info", "Here's my linkedin account link");
        model.addAttribute("linkedin", "https://www.linkedin.com/in/nimish-bhalerao/");
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading...");
        return "about";
    }

    @GetMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading...");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Nimish");
        // userForm.setEmail("nimish@gmail.com");
        model.addAttribute("userForm", userForm);

        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rbindingResult, HttpSession session) {
        System.out.println("Processing register");
        System.out.println(userForm);

        // validating form data

        if (rbindingResult.hasErrors()) {
            System.out.println("Form has errors");
            return "register";
        }

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://media.istockphoto.com/id/610003972/vector/vector-businessman-black-silhouette-isolated.jpg?s=612x612&w=0&k=20&c=Iu6j0zFZBkswfq8VLVW8XmTLLxTLM63bfvI6uXdkacM=")
        // .build();

        // test for git

        User user = new User();
        user.setName(userForm.getName());
        user.setAbout(userForm.getAbout());
        user.setEmail(userForm.getEmail());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setPassword(userForm.getPassword());
        user.setProfilePic(
                "https://media.istockphoto.com/id/610003972/vector/vector-businessman-black-silhouette-isolated.jpg?s=612x612&w=0&k=20&c=Iu6j0zFZBkswfq8VLVW8XmTLLxTLM63bfvI6uXdkacM=");

        User savedUser = userService.saveUser(user);
        System.out.println("Saved user: ");
        Message message = Message.builder().content("Registration sucessfull!!").type(MessageType.green).build();
        session.setAttribute("message", message);
        return "redirect:/register";
    }
}
