package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.match.model.Match;
import com.example.SoccerArticleCollection.match.model.MatchCrawler;
import com.example.SoccerArticleCollection.match.model.UrlMaker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatchServiceTest {
    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchRepository matchRepository;

    MatchCrawler mc = new MatchCrawler();

    @Test
    void findAll() {
        List<Match> allByHasMatchIsTrue = matchRepository.findAllByHasMatchIsTrue();
        List<Match> list = new ArrayList<>();
        for (Match match : allByHasMatchIsTrue) {
            String substring = match.getMatchLink().substring(35, 43);
            match.setDate(substring);
            list.add(match);
        }
        matchRepository.saveAll(list);
    }

    @Test
    void saveMatchInfo() {
        UrlMaker url = new UrlMaker();
        url.setYear(url.getYear() + "2022");
        url.setMonth(url.getMonth() + "10");
        List<Match> matches = mc.crawlSchedule(url);

        matchRepository.saveAll(matches);
    }
}