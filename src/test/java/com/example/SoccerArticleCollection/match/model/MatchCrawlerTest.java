package com.example.SoccerArticleCollection.match.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

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