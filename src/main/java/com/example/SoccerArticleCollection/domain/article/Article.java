package com.example.SoccerArticleCollection.domain.article;

import com.example.SoccerArticleCollection.domain.match.Match;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", articleLink='" + articleLink + '\'' +
                ", articleType=" + articleType +
                '}';
    }
}
