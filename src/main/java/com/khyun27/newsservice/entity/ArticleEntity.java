package com.khyun27.newsservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    @Builder.Default
    private String author = "";

    @Column(length = 300)
    @Builder.Default
    private String title = "";

    @Column(length = 1000)
    @Builder.Default
    private String description = "";

    @Column(length = 2048)
    @Builder.Default
    private String url = "";

    @Column(length = 2048)
    @Builder.Default
    private String urlToImage = "";

    @Column
    @CreationTimestamp
    private LocalDateTime publishedAt;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category_id;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private SourceEntity source_id;
}
