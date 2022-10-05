package com.example.SoccerArticleCollection.controller;

import com.example.SoccerArticleCollection.domain.match.Match;
import com.example.SoccerArticleCollection.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    @GetMapping("")
    public List<Match> get() {
        return matchService.saveMatchList();
    }
}
