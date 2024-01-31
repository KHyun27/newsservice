package com.khyun27.newsservice.service;

import com.khyun27.newsservice.dto.ArticleDTO;
import com.khyun27.newsservice.dto.CategoryDTO;
import com.khyun27.newsservice.dto.CountryDTO;
import com.khyun27.newsservice.dto.SourceDTO;
import com.khyun27.newsservice.entity.ArticleEntity;
import com.khyun27.newsservice.entity.CategoryEntity;
import com.khyun27.newsservice.entity.CountryEntity;
import com.khyun27.newsservice.entity.SourceEntity;
import com.khyun27.newsservice.repository.ArticleRepository;
import com.khyun27.newsservice.repository.CategoryRepository;
import com.khyun27.newsservice.repository.CountryRepository;
import com.khyun27.newsservice.repository.SourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final CategoryRepository categoryRepository;
    private final CountryRepository countryRespository;
    private final SourceRepository sourceRepository;
    private final ArticleRepository articleRepository;

    public List<CategoryDTO> findAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        ArrayList<CategoryDTO> list = new ArrayList<>();

        for (CategoryEntity category : categoryEntities) {
            // System.out.println(category);
            list.add(CategoryDTO.fromCategoryEntity(category));
        }

        return list;
    }

    public List<CountryDTO> findAllCountries() {
        List<CountryEntity> countryEntities = countryRespository.findAll();

        ArrayList<CountryDTO> list = new ArrayList<>();

        for (CountryEntity country : countryEntities) {
            // System.out.println(country);
            list.add(CountryDTO.fromCountryEntity(country));
        }

        return list;
    }

    public List<SourceDTO> findAllSources() {
        List<SourceEntity> sourceEntities = sourceRepository.findAll();

        ArrayList<SourceDTO> list = new ArrayList<>();

        for (SourceEntity source : sourceEntities) {
            // System.out.println(source);
            list.add(SourceDTO.fromSourceEntity(source));
        }

        return list;
    }

    public Page<ArticleEntity> findAll(int page, int size) {
        return articleRepository.findAll(PageRequest.of(page, size, Sort.by("publishedAt").descending()));
    }

    public CategoryDTO saveCategory(CategoryDTO category) {
        CategoryEntity categoryEntity = CategoryEntity.fromCategoryDTO(category);
        CategoryEntity saved = categoryRepository.save(categoryEntity);

        return CategoryDTO.fromCategoryEntity(saved);
    }
}