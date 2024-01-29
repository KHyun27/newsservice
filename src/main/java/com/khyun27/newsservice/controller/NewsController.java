package com.khyun27.newsservice.controller;

import com.khyun27.newsservice.dto.CategoryDTO;
import com.khyun27.newsservice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/category")
    public String getCategories(Model model) {

        List<CategoryDTO> categories = newsService.findAllCategories();

        model.addAttribute("categories",categories);

        return "/category";
    }
}
