package com.example.SoccerArticleCollection.service;

import com.example.SoccerArticleCollection.domain.article.Article;
import com.example.SoccerArticleCollection.domain.article.ArticleCrawler;
import com.example.SoccerArticleCollection.domain.match.Match;
import com.example.SoccerArticleCollection.repository.ArticleRepository;
import com.example.SoccerArticleCollection.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MatchRepository matchRepository;

    public List<Article> bbcArticleCrawling() {

        ArticleCrawler articleCrawler = new ArticleCrawler();
        List<Article> articles = articleCrawler.crawlBBCArticleByMatch();
        return articleRepository.saveAll(articles);
    }

    public List<Article> naverArticleCrawling() {
        ArticleCrawler articleCrawler = new ArticleCrawler();
        List<Article> articles = articleCrawler.crawlNAVERArticleByMatch();
        return articleRepository.saveAll(articles);

    }


}
