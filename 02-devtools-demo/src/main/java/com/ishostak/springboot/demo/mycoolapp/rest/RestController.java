package com.ishostak.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //expose "/" endpoint Hello World

    @GetMapping("/")
    public String sayHello() {
        return "Hello world " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getWorkou() {
        return "Run over the world twice";
    }
}
