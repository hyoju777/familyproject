package com.ohgiraffers.khjblog.repository;

import com.ohgiraffers.khjblog.model.entity.User; // User 엔티티 클래스 필요
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // 사용자 이름으로 조회
}

