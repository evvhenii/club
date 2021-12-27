package com.example.club.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping
    public String get() {
        return "redirect:/members";
    }
}
