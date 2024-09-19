package com.ohgiraffers.familyapp.Service; // 패키지 선언

import com.ohgiraffers.familyapp.Exception.UserNotFoundException; // 추가
import com.ohgiraffers.familyapp.Model.User;
import com.ohgiraffers.familyapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; // List 임포트
import java.util.Optional; // Optional 임포트

@Service
public class UserService {
    @Autowired // UserRepository 자동 주입
    private UserRepository userRepository;

    // 사용자 저장
    public User saveUser(User user) {
        return userRepository.save(user); // 사용자 저장 메서드
    }

    // ID로 사용자 조회
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id); // ID로 사용자 조회
    }

    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll(); // 모든 사용자 조회
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // ID로 사용자 삭제
    }

    // 사용자 정보 업데이트
    public User updateUser(Long id, User userDetails) {
        // 사용자 찾기, 없으면 예외 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id)); // 수정

        // 사용자 정보 업데이트
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user); // 업데이트된 사용자 저장
    }
}
