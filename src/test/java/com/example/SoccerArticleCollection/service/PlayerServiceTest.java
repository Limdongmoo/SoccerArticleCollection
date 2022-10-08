package com.example.SoccerArticleCollection.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Test
    @DisplayName("득점 랭킹 크롤링 테스트")
    void playerScoreRankingCrawlTest() {
        playerService.saveScoreRanking();
    }

    @Test
    @DisplayName("어시스트 랭킹 크롤링 테스트")
    void playerAssistsRankingCrawlTest() {
        playerService.saveAssistsRanking();
    }

    @Test
    @DisplayName("골 랭킹 조회 서비스 테스트")
    void getScoreRankingTest(){
        playerService.getScoreRanking()
                .forEach(System.out::println);

    }

    @Test
    @DisplayName("어시스트 랭킹 조회 서비스 테스트")
    void getAssistsRankingTest(){
        playerService.getAssistsRanking()
                .forEach(System.out::println);

    }

}