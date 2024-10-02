package com.ohgiraffers.khjblog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordDemo {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "HyojuBlog1234"; // 원래 비밀번호
        String hashedPassword = encoder.encode(rawPassword); // 해시 생성
        System.out.println(hashedPassword); // 해시 출력
    }
}
