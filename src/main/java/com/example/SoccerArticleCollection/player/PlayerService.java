package com.example.SoccerArticleCollection.player;

import com.example.SoccerArticleCollection.player.model.TopPlayer;
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
        return playerRepository.saveAll(topPlayers);
    }

}
