package com.khyun27.newsservice.repository;

import com.khyun27.newsservice.entity.SourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<SourceEntity, Long> {
}
