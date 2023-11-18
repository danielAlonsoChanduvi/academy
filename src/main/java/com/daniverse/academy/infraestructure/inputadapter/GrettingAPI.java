package com.daniverse.academy.infraestructure.inputadapter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GrettingAPI {

    @GetMapping("/greetings")
    public String getGrettings() {
        return "Hello, here is DanielVerse";
    }

}
