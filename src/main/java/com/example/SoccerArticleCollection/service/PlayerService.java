package com.example.SoccerArticleCollection.service;

import com.example.SoccerArticleCollection.domain.player.PlayerCrawler;
import com.example.SoccerArticleCollection.domain.player.RankType;
import com.example.SoccerArticleCollection.domain.player.TopPlayer;
import com.example.SoccerArticleCollection.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;



    public List<TopPlayer> saveGoalRanking() {

        PlayerCrawler playerCrawler = new PlayerCrawler();

        List<TopPlayer> topPlayers = playerCrawler.scoreRankCrawler();
        playerRepository.deleteAllByRankType(RankType.SCORE);

        return playerRepository.saveAll(topPlayers);
    }

    public List<TopPlayer> saveAssistsRanking() {

        PlayerCrawler playerCrawler = new PlayerCrawler();

        List<TopPlayer> topPlayers = playerCrawler.assistsRankCrawler();
        playerRepository.deleteAllByRankType(RankType.ASSISTS);

        return playerRepository.saveAll(topPlayers);
    }

}
