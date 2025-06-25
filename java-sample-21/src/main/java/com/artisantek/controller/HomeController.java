package com.artisantek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("company", "ArtisanTek");
        model.addAttribute("batch", "May2025");
        model.addAttribute("message", "Welcome to the Future of Technology");
        return "index";
    }
} 