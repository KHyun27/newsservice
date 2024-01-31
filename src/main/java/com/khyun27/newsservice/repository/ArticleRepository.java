package com.khyun27.newsservice.repository;

import com.khyun27.newsservice.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Page<ArticleEntity> findAll(Pageable pageable);
}
