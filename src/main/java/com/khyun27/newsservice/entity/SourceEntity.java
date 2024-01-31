package com.khyun27.newsservice.entity;

import com.khyun27.newsservice.dto.SourceDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "source")
public class SourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String s_id;

    @Column(length = 50)
    private String s_name;

    public static SourceEntity fromSourceDTO(SourceDTO sourceDTO) {
        return SourceEntity.builder()
                .s_id(sourceDTO.getS_id())
                .s_name(sourceDTO.getS_name())
                .build();
    }

}
