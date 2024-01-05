package com.bookStore.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {
    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }}
