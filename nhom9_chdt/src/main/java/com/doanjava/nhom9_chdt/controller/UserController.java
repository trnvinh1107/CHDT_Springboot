package com.doanjava.nhom9_chdt.controller;

import com.doanjava.nhom9_chdt.entity.User;
import com.doanjava.nhom9_chdt.repository.UserRepository;
import com.doanjava.nhom9_chdt.service.EmailService;
import com.doanjava.nhom9_chdt.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           @NotNull BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            return "user/register";
        }
        userService.save(user);
        userService.setDefaultRole(user.getUsername());
        return "redirect:/login";
    }

    @GetMapping("/registerNV")
    public String registerNV(Model model) {
        model.addAttribute("user", new User());
        return "user/registerNV";
    }

    @PostMapping("/registerNV")
    public String registerNV(@Valid @ModelAttribute("user") User user,
                           @NotNull BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            return "user/registerNV";
        }
        userService.save(user);
        userService.setRoleNV(user.getUsername());
        return "redirect:/role/2";
    }
    @GetMapping("/role/{role}")
    public String getUsersByRole(@PathVariable long role, Model model) {
        List<User> users = userService.getUserByRole(role);
        model.addAttribute("users", users);
        return "user/users";
    }


    @GetMapping("/forgot-password")
    public String showForgotPassword (Model model,@ModelAttribute("user") User userEntity) {
        String email = userEntity.getEmail();
        model.addAttribute("email", email);
        return "user/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword (Model model, @ModelAttribute("user") User user) {
        String emailId = user.getEmail();
        User userEntity = userRepository.findByEmailIgnoreCase(emailId);
        if (userEntity == null) {
            model.addAttribute("message", "Email does not exist!");
            return "error";
        } else {
            String generatedPassword = UUID.randomUUID().toString().substring(0, 16);
            userEntity.setPassword(new BCryptPasswordEncoder().encode(generatedPassword));

            userRepository.save(userEntity);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Password Reset!");
            mailMessage.setFrom("nhomjava09@gmail.com");
            mailMessage.setText("To complete the password reset here : "  +  generatedPassword);


            emailService.sendEmail(mailMessage);

            model.addAttribute("email", user.getEmail());

            model.addAttribute("message", "Request to reset password received. " +
                    "Check your inbox for the reset link.");
            return "user/successfulRegisteration";
        }
    }
}

