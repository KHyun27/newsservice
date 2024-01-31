package com.khyun27.newsservice.entity;

import com.khyun27.newsservice.dto.CategoryDTO;
import com.khyun27.newsservice.dto.CountryDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String c_code;

    @Column(nullable = false, length = 50)
    private String c_name;

    public static CountryEntity fromCountryDTO(CountryDTO countryDTO) {
        return CountryEntity.builder()
                .c_code(countryDTO.getC_code())
                .c_name(countryDTO.getC_name())
                .build();
    }
}
