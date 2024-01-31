package com.khyun27.newsservice.dto;

import com.khyun27.newsservice.entity.SourceEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SourceDTO {
    private Long id;
    private String s_id;
    private String s_name;

    public static SourceDTO fromSourceEntity(SourceEntity sourceEntity) {
        return SourceDTO.builder()
                .s_id(sourceEntity.getS_id())
                .s_name(sourceEntity.getS_name())
                .build();
    }
}
