package com.kyukeoton_b.kyukeotonB_be.domain.user.controller;

import com.kyukeoton_b.kyukeotonB_be.domain.user.dto.UserResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.user.service.UserService;
import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/user/{userId}")
    public ApiResponse<UserResponse> findDochinZZal(@PathVariable Long userId) {
        UserResponse myPage = userService.findMyPage(userId);
        return ApiResponse.onSuccess(myPage);
    }

}
