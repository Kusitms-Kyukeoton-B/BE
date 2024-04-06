//package com.kyukeoton_b.kyukeotonB_be.global.jwt;
//
//import io.jsonwebtoken.IncorrectClaimException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//
//    public JwtAuthenticationFilter(JwtService provider) {
//        jwtService = provider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = resolveToken(request);
//
//        try {
//            if(token != null && jwtService.validateAccessToken(token)) {
//                Authentication authentication = jwtService.getAuthentication(token);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//                log.debug("Save authentication in SecurityContextHolder.");
//            }
//        } catch (IncorrectClaimException e) { //잘못된 토큰일 경우
//            SecurityContextHolder.clearContext();
//            log.debug("Invalid JWT token");
//            response.sendError(403);
//        } catch (UsernameNotFoundException e) { //회원을 찾을 수 없을 경우
//            SecurityContextHolder.clearContext();
//            log.debug("Can't find user");
//            response.sendError(403);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//    public String resolveToken(HttpServletRequest request) {
//        return request.getHeader("X-AUTH-TOKEN");
//    }
//}
