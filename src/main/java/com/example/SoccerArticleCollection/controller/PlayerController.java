package com.example.SoccerArticleCollection.controller;

import com.example.SoccerArticleCollection.domain.player.TopPlayer;
import com.example.SoccerArticleCollection.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("")
    public List<TopPlayer> saveScoreRanking() {
        return playerService.saveScoreRanking();
    }



    @GetMapping("/assists")
    public List<TopPlayer> saveAssistsRanking() {
        return playerService.saveAssistsRanking();
    }

}
