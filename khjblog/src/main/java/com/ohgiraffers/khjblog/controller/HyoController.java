package com.ohgiraffers.khjblog.controller;

import com.ohgiraffers.khjblog.service.HyoService;
import com.ohgiraffers.khjblog.service.LoginService; // LoginService 추가
import com.ohgiraffers.khjblog.repository.UserRepository; // UserRepository 추가
import com.ohgiraffers.khjblog.model.entity.User; // User 엔티티 추가
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hyo")
public class HyoController {

    private final HyoService hyoService;
    private final LoginService loginService; // LoginService 필드 추가
    private final UserRepository userRepository; // UserRepository 필드 추가

    @Autowired
    public HyoController(HyoService hyoService, LoginService loginService, UserRepository userRepository) {
        this.hyoService = hyoService;
        this.loginService = loginService; // 의존성 주입
        this.userRepository = userRepository; // UserRepository 의존성 주입
    }

    @GetMapping("/main")
    public String mainpage() {
        return "/hyo/main";
    }

    @GetMapping("/post")
    public String showPostForm() {
        return "/hyo/post";
    }

    // 로그인 요청을 처리하는 메서드
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        String storedHash = getPasswordHashFromDatabase(username); // 사용자 해시 비밀번호 조회

        if (loginService.login(password, storedHash)) {
            return "redirect:/hyo/main"; // 인증 성공 시 메인 페이지로 리다이렉트
        } else {
            model.addAttribute("error", true); // 로그인 실패 시 에러 메시지 표시
            return "hyo/login"; // 로그인 페이지로 이동
        }
    }

    // 데이터베이스에서 사용자 해시 비밀번호를 조회하는 메서드
    private String getPasswordHashFromDatabase(String username) {
        User user = userRepository.findByUsername(username); // 사용자 조회
        return user != null ? user.getPassword() : null; // 해시된 비밀번호 반환
    }

    // 로그아웃 요청을 처리하는 메서드
    @PostMapping("/logout")
    public String logout() {
        // 로그아웃 로직
        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }
}
