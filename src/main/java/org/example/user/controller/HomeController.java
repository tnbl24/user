package org.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home22")
    public String home22(){
        return "home";
    }

    @GetMapping("/trangchu")
    public String trangchu(){
        return "trangchu2";
    }

}
