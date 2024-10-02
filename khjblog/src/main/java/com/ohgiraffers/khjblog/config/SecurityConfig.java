package com.ohgiraffers.khjblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/login").permitAll() // 로그인 페이지 접근 허용
                        .anyRequest().authenticated() // 모든 요청 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login") // 로그인 페이지 URL
                        .defaultSuccessUrl("/home", true) // 로그인 성공 후 리디렉션할 URL
                        .permitAll() // 모든 사용자에게 로그인 페이지 접근 허용
                )
                .logout(logout -> logout
                        .permitAll()); // 모든 사용자에게 로그아웃 허용
        return http.build(); // HttpSecurity 빌드 및 반환
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder 반환
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        // AuthenticationManagerBuilder를 HttpSecurity에서 가져오기
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("user") // 사용자 이름
                .password(passwordEncoder().encode("password")) // 비밀번호 (BCrypt로 인코딩)
                .roles("USER"); // 역할 설정

        return authenticationManagerBuilder.build(); // AuthenticationManager 반환
    }
}
