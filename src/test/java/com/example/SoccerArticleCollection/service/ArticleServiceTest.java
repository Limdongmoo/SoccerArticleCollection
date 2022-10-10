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
    @DisplayName("BBS 기사 크롤링 테스트")
    @Commit
    void articleCrawling() {
        List<Article> articles = articleService.bbcArticleCrawling();
        articles.forEach(System.out::println);
    }
}