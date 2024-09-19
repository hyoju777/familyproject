package com.ohgiraffers.familyapp.Model; // 패키지 선언


import jakarta.persistence.*;

@Entity // JPA 엔티티로 정의
@Table(name = "users") // 데이터베이스의 'users' 테이블과 매핑
public class User {
    @Id // 기본 키 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 생성
    private Long id;

    @Column(name = "username", nullable = false) // username 필드에 대한 매핑, NULL을 허용하지 않음
    private String username;

    @Column(name = "password", nullable = false) // password 필드에 대한 매핑, NULL을 허용하지 않음
    private String password;

    @Column(name = "email", nullable = false, unique = true) // email 필드에 대한 매핑, 고유 제약조건 추가
    private String email;

    // 기본 생성자
    public User() {}

    // Getter와 Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email; // 불필요한 줄바꿈 제거
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
