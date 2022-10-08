package com.example.SoccerArticleCollection.service;

import com.example.SoccerArticleCollection.domain.player.*;
import com.example.SoccerArticleCollection.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;



    public List<TopPlayer> saveScoreRanking() {

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

    public List<GetScoreRankingRes> getScoreRanking() {

        List<TopPlayer> allByRankType = playerRepository.findAllByRankType(RankType.SCORE);
        return allByRankType.stream()
                .map(GetScoreRankingRes::from)
                .collect(Collectors.toList());

    }

    public List<GetAssistsRankingRes> getAssistsRanking() {

        List<TopPlayer> allByRankType = playerRepository.findAllByRankType(RankType.ASSISTS);
        return allByRankType.stream()
                .map(GetAssistsRankingRes::from)
                .collect(Collectors.toList());
    }

}
