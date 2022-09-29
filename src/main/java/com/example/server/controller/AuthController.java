//package com.example.server.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/api")
//public class AuthController {
//
//    @GetMapping("/login")
//    public String getLoginPage(Model model) {
//        return "login/login";
//    }
//
//    @GetMapping("/denied")
//    public String getAccessDeniedPage() {
//        return "login/denied";
//    }
//
//    @GetMapping("/success")
//    public String getSuccessPage() {
//        return "login/success";
//    }
//}