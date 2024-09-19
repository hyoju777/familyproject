package com.ohgiraffers.familystory.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; // 추가: Table 어노테이션 import
import javax.persistence.Column; // 추가: Column 어노테이션 import

@Entity
@Table(name ="users")// 데이터베이스의 'users' 테이블과 매핑
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동생성
    private Long id;

    @Column(name = "username",nullable = false) // 추가: username 필드에 대한 매핑,username 필드는 NULL을 허용하지 않도록 설정
    private String username;

    @Column(name = "password",nullable = false) // 추가: password 필드에 대한 매핑,password 필드는 NULL을 허용하지 않도록 설정
    private String password;

    @Column(name = "email",nullable = false, unique = true) // 추가: email 필드에 대한 매핑,email 필드에 대한 매핑, 고유 제약조건 추가
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

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
