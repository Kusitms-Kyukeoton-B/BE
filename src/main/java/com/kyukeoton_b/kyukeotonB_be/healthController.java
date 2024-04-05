package com.kyukeoton_b.kyukeotonB_be;

import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthController {
    @GetMapping("/user")
    public ApiResponse<String> hello() {
        return ApiResponse.onSuccess("Hello, Kyukeoton and Retest");
    }
}
