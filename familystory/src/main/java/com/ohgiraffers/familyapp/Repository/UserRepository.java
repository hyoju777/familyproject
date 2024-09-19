package com.ohgiraffers.familyapp.Repository; // 패키지 선언

import com.ohgiraffers.familyapp.Model.User; // User 모델 임포트
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository 임포트

import java.util.Optional; // Optional 임포트

public interface UserRepository extends JpaRepository<User, Long> { // User 엔티티와 Long 타입 ID를 사용하는 JPA 리포지토리
    Optional<User> findByUsername(String username); // username으로 사용자 검색 메서드
}
