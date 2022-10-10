package com.example.SoccerArticleCollection.domain.article;

import com.example.SoccerArticleCollection.domain.match.Match;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    @Builder
    public Article(String title, String articleLink, ArticleType articleType) {
        this.title = title;
        this.articleLink = articleLink;
        this.articleType = articleType;
    }



    public static Article fromBBC(WebElement element) {
        WebElement anchor = element.findElement(By.tagName("a"));
        String articleTitle = anchor.getText();
        String articleLink = anchor.getAttribute("href");

        return Article.builder()
                .articleLink(articleLink)
                .title(articleTitle)
                .articleType(ArticleType.BBC)
                .build();
    }
}
