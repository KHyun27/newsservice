package com.khyun27.newsservice.entity;

import com.khyun27.newsservice.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String ct_code;

    @Column(nullable = false, unique = true, length = 50)
    private String ct_name;

    @Column(length = 100)
    @Builder.Default
    private String ct_desc = "";

    public static CategoryEntity fromCategoryDTO(CategoryDTO categoryDTO) {
        return CategoryEntity.builder()
                .ct_code(categoryDTO.getCt_code())
                .ct_name(categoryDTO.getCt_name())
                .ct_desc(categoryDTO.getCt_desc())
                .build();
    }
}
