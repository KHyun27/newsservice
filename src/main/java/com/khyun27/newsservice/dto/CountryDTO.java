package com.khyun27.newsservice.dto;

import com.khyun27.newsservice.entity.CategoryEntity;
import com.khyun27.newsservice.entity.CountryEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CountryDTO {

    private Long id;
    private String c_code;
    private String c_name;

    public static CountryDTO fromCountryEntity(CountryEntity countryEntity) {
        return CountryDTO.builder()
                .id(countryEntity.getId())
                .c_code(countryEntity.getC_code())
                .c_name(countryEntity.getC_name())
                .build();
    }
}
