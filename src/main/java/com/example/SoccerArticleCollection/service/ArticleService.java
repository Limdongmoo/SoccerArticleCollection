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

    public void articleCrawling() {
        Optional<Match> byId = matchRepository.findById(4977L);
        Match match = byId.get();
        String matchTeam1 = match.getMatchTeam1();
        String matchTeam2 = match.getMatchTeam2();

        ArticleCrawler articleCrawler = new ArticleCrawler();
        articleCrawler.crawlBBCArticleByMatch(matchTeam1, matchTeam2);


    }


}
