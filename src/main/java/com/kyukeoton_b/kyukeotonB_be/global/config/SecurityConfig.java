//package com.kyukeoton_b.kyukeotonB_be.global.config;
//
//import com.kyukeoton_b.kyukeotonB_be.global.jwt.JwtAuthenticationEntryPoint;
//import com.kyukeoton_b.kyukeotonB_be.global.jwt.JwtAuthenticationFilter;
//import com.kyukeoton_b.kyukeotonB_be.global.jwt.JwtService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final JwtService jwtService;
//    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable()
//                .cors().and()
//                .csrf().disable()
//                .formLogin().disable()
//                .sessionManagement().sessionCreationPolicy((SessionCreationPolicy.STATELESS))
//                .and()
//                .exceptionHandling()
//                //.authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and();
//                //.addFilterBefore(new JwtAuthenticationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
