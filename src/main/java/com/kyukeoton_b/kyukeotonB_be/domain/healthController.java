package com.kyukeoton_b.kyukeotonB_be.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthController {
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}
