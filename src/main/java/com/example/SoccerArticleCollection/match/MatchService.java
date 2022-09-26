package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.match.model.Match;
import com.example.SoccerArticleCollection.match.model.SeleniumCrawler;
import com.example.SoccerArticleCollection.match.model.UrlMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchService {
    private final MatchRepository matchRepository;

    /**
     * 1. 매치 List 저장하기
     */
    public List<Match> saveMatchList() {
        SeleniumCrawler seleniumCrawler = new SeleniumCrawler();
        UrlMaker urlMaker = new UrlMaker();
        String year = "2022";
        String month = "09";

    }



}
