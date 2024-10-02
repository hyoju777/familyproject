package com.ohgiraffers.khjblog.repository;

import com.ohgiraffers.khjblog.model.entity.HyoBlog;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 인터페이스를 선언, JunBlog 엔티티를 관리하고, 기본 키의 타입은 Integer
public interface HyoRepository extends JpaRepository<HyoBlog, Long> {


}
