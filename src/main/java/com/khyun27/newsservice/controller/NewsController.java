package com.khyun27.newsservice.controller;

import com.khyun27.newsservice.dto.CategoryDTO;
import com.khyun27.newsservice.dto.CountryDTO;
import com.khyun27.newsservice.dto.SourceDTO;
import com.khyun27.newsservice.entity.ArticleEntity;
import com.khyun27.newsservice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/")
    public String newsMain(Model model) {
        model.addAttribute("nick_name", "khyun27");

        return "/index";
    }

    @GetMapping("/articles")
    public String articles(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        try {
            Page<ArticleEntity> articles = newsService.findAll(page, size);



        } catch (Exception e) {
            model.addAttribute("message",e.getMessage());
            return "/error";
        }
        return "/index";
    }

    @GetMapping("/category")
    public String getCategories(Model model) {
        List<CategoryDTO> categories = newsService.findAllCategories();
        model.addAttribute("categories", categories);
        return "/category";
    }

    @GetMapping("/country")
    public String getCountries(Model model) {
        List<CountryDTO> countries = newsService.findAllCountries();
        model.addAttribute("countries", countries);
        return "/country";
    }

    @GetMapping("/source")
    public String getSources(Model model) {
        List<SourceDTO> sources = newsService.findAllSources();
        model.addAttribute("sources", sources);
        return "/source";
    }

    @GetMapping("/categoryInput")
    public String inputCategory() {
        return "category_input";
    }

    @PostMapping("/categorySave")
    public String saveCategory(@RequestParam("categoryCode") String code,
                               @RequestParam("categoryName") String name,
                               @RequestParam("categoryDesc") String desc) {

        CategoryDTO category = CategoryDTO.builder()
                .ct_code(code)
                .ct_name(name)
                .ct_desc(desc)
                .build();

        CategoryDTO saved = newsService.saveCategory(category);
        System.out.println(saved);

        return "redirect:/category";
    }

    @GetMapping("/countryInput")
    public String inputCountry() {
        return "country_input";
    }
}
