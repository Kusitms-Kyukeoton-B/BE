//package com.kyukeoton_b.kyukeotonB_be.global.jwt;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Security 예외 처리를 위해 설정한 클래스
// * 인가(Authorization)가 실패했을 때 실행
// * 예를 들자면, 로그인 된 사용자가 필요한 요청에 로그인하지 않은 사용자가 접근했을 때 실행
// */
//@Slf4j
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setCharacterEncoding("utf-8");
//        response.sendError(401, "잘못된 접근입니다.");
//    }
//}
