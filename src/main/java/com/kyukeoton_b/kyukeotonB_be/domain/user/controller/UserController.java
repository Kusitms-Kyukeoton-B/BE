package com.kyukeoton_b.kyukeotonB_be.domain.user.controller;

import com.kyukeoton_b.kyukeotonB_be.domain.user.dto.PostLoginReq;
import com.kyukeoton_b.kyukeotonB_be.domain.user.dto.TokenDto;
import com.kyukeoton_b.kyukeotonB_be.domain.user.service.UserService;
import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import com.kyukeoton_b.kyukeotonB_be.global.jwt.JwtSecret;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final long COOKIE_EXPIRATION = JwtSecret.COOKIE_EXPIRATION_TIME;
    private final UserService userService;

    @PostMapping("/log-in")
    public ResponseEntity<?> login(@RequestBody PostLoginReq postLoginReq) {
        //User 등록 및 Refresh Token 저장
        TokenDto tokenDto = userService.login(postLoginReq);

        //RefreshToken 쿠키에 저장
        HttpCookie httpCookie = ResponseCookie.from("refresh-token", tokenDto.getRefreshToken())
                .maxAge(COOKIE_EXPIRATION)
                .httpOnly(true)
                .secure(true)
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, httpCookie.toString())
                .header("X-AUTH-TOKEN", tokenDto.getAccessToken())
                .build();
    }

}
