package com.example.SoccerArticleCollection.domain.article;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column
    private String title;

    @Column
    private String articleLink;

    @Column
    @Enumerated(EnumType.STRING)
    private ArticleType articleType;

    @Column
    @CreatedDate
    private LocalDate createdDate;

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", articleLink='" + articleLink + '\'' +
                ", articleType=" + articleType +
                ", date=" + createdDate +
                '}';
    }

    @Builder
    public Article(String title, String articleLink, ArticleType articleType) {
        this.title = title;
        this.articleLink = articleLink;
        this.articleType = articleType;
    }


}
