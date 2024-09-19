package com.ohgiraffers.familyapp.Controller; // 패키지 선언

import com.ohgiraffers.familyapp.Exception.UserNotFoundException; // 추가
import com.ohgiraffers.familyapp.Model.User;
import com.ohgiraffers.familyapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // RESTful 웹 서비스 클래스임을 선언
@RequestMapping("/api/users") // 기본 URL 매핑 설정
public class UserController {

    @Autowired // UserService를 자동 주입
    private UserService userService;

    @PostMapping // POST 요청 처리
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // 사용자 저장 메서드 호출
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser); // 생성된 사용자 반환
    }

    @GetMapping("/{id}") // GET 요청 처리
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // 사용자 조회 메서드 호출
        return userService.getUser(id)
                .map(ResponseEntity::ok) // 사용자가 존재하면 200 상태 코드 반환
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id)); // 수정
    }
}
