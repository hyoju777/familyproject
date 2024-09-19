package com.ohgiraffers.familyapp; // 패키지 선언

import org.springframework.boot.SpringApplication; // SpringApplication 클래스 임포트
import org.springframework.boot.autoconfigure.SpringBootApplication; // SpringBootApplication 어노테이션 임포트

@SpringBootApplication // Spring Boot 애플리케이션의 설정 및 자동 구성을 활성화
public class FamilystoryApplication { // 애플리케이션 클래스 선언
	public static void main(String[] args) { // main 메서드
		SpringApplication.run(FamilystoryApplication.class, args); // 애플리케이션 실행
	}
}
