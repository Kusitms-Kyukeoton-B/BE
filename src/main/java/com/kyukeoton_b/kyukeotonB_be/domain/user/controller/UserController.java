package com.kyukeoton_b.kyukeotonB_be.domain.user.controller;

import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ApiResponse<String> test() {
        return ApiResponse.onSuccess("마지막 테스트");
    }
}
