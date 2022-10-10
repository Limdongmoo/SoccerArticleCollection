package com.example.SoccerArticleCollection.service;

import com.example.SoccerArticleCollection.domain.article.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    @DisplayName("BBC 기사 크롤링 테스트")
    void articleCrawling() {
        List<Article> articles = articleService.bbcArticleCrawling();
        articles.forEach(System.out::println);
    }

    @Test
    @DisplayName("NAVER 기사 크롤링 테스트")
    void articleCrawlingNaver() {
        List<Article> articles = articleService.naverArticleCrawling();
        articles.forEach(System.out::println);

    }
}