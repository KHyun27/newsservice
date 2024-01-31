package com.khyun27.newsservice.repository;

import com.khyun27.newsservice.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
