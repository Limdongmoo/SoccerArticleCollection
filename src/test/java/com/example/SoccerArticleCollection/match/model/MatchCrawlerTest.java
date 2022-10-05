package com.example.SoccerArticleCollection.match.model;

import com.example.SoccerArticleCollection.domain.match.MatchCrawler;
import com.example.SoccerArticleCollection.domain.match.UrlMaker;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;

class MatchCrawlerTest {

    MatchCrawler mc = new MatchCrawler();

    @Test
    void playedMatchCrawler() {
        mc.playedMatchCrawler();
    }

    @Test
    @Commit
    void matchCrawling() {
        UrlMaker urlMaker = new UrlMaker();
        urlMaker.setYear("2022");
        urlMaker.setMonth("11");
        mc.crawlSchedule(urlMaker);
    }
}