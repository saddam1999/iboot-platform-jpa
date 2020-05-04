package com.iboot.demo.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/demo")
public class HelloController {

    @GetMapping("/index")
    public String indexThymeleaf(Model model) {
        model.addAttribute("msg","測試thymeleaf頁面！！！");
        return "demo/index";
    }

    @GetMapping("/hello")
    public String hello2(Model model) {
        return "/demo/hello";

    }

    @GetMapping("/success")
    public String hello(Model model) {
        model.addAttribute("msg", "您好！！！");
        return "/demo/success";

    }
}