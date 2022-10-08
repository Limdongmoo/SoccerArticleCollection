package com.example.SoccerArticleCollection.repository;

import com.example.SoccerArticleCollection.domain.player.RankType;
import com.example.SoccerArticleCollection.domain.player.TopPlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    @DisplayName("랭킹 조회 레포 테스트")
    void findAllByRankType() {
        List<TopPlayer> allByRankScore = playerRepository.findAllByRankType(RankType.SCORE);
        List<TopPlayer> allByRankAssists = playerRepository.findAllByRankType(RankType.ASSISTS);

        System.out.println("골 랭킹");
        for (TopPlayer p : allByRankScore) {
            System.out.println("p = " + p);
        }

        System.out.println();
        System.out.println("어시스트 랭킹");
        for (TopPlayer p : allByRankAssists) {
            System.out.println("p = " + p);
        }
    }

}