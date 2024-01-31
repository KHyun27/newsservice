package com.khyun27.newsservice.dto;

import com.khyun27.newsservice.entity.CategoryEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryDTO {
    private Long id;
    private String ct_code;
    private String ct_name;
    private String ct_desc;

    public static CategoryDTO fromCategoryEntity(CategoryEntity categoryEntity) {
        return CategoryDTO.builder()
                .id(categoryEntity.getId())
                .ct_code(categoryEntity.getCt_code())
                .ct_name(categoryEntity.getCt_name())
                .ct_desc(categoryEntity.getCt_desc())
                .build();
    }
}
