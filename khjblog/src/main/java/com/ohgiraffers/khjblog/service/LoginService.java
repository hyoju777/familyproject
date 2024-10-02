package com.ohgiraffers.khjblog.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service; // 추가: Spring의 관리 빈으로 등록하기 위한 어노테이션

@Service // 추가: 이 클래스를 Spring 빈으로 등록
public class LoginService {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean login(String inputPassword, String storedHash) {
        return passwordEncoder.matches(inputPassword, storedHash);
    }
}
