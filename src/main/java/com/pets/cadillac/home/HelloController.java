package com.pets.cadillac.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/login")
    public String index() {
        return "Greetings from Spring Boot!!!!";
    }

}