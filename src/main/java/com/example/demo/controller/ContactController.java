package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ContactForm;
import com.example.demo.service.EmailService;
import org.springframework.ui.Model;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String showPortfolio(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "index"; // Make sure this matches your template name
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute ContactForm contactForm, Model model) {
        try {
            emailService.sendContactEmail(contactForm.getEmail(), contactForm.getName(), contactForm.getMessage());
            model.addAttribute("contactForm", new ContactForm());
            model.addAttribute("Sucess", "Message sent successfully! 🚀");
        } catch (Exception e) {
            model.addAttribute("contactForm", contactForm);
            model.addAttribute("error", "Failed to send message. Please try again.");
        }
        return "index";
    }
}