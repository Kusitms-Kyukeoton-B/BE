package com.kyukeoton_b.kyukeotonB_be;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthController {
//    @GetMapping("/health-check")
//    public String hello() {
//        return "Hello, KyuKeoton!";
//    }

    @GetMapping("/health-check")
    public String hello() {
        return "Hello, KyuKeoton!";
    }
}
