package com.khyun27.newsservice.repository;

import com.khyun27.newsservice.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Page<ArticleEntity> findAll(Pageable pageable);

    @Query("SELECT a FROM ArticleEntity a WHERE " + "a.title LIKE %:titleKeyword% OR a.description LIKE %:descKeyword%")
    Page<ArticleEntity> findByTitleOrDescription(String titleKeyword, String descKeyword, Pageable pageable);

    @Query("SELECT a FROM ArticleEntity a WHERE a.category.id = :categoryId AND " + "a.title LIKE %:titleKeyword% OR a.description LIKE %:descKeyword%")
    Page<ArticleEntity> findByCategoryAndTitleOrDescription(Long categoryId, String titleKeyword, String descKeyword, Pageable pageable);
}

