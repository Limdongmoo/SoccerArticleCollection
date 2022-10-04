package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.config.BaseException;
import com.example.SoccerArticleCollection.match.model.Match;
import com.example.SoccerArticleCollection.match.model.MatchCrawler;
import com.example.SoccerArticleCollection.match.model.UrlMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.sql.Date;
import java.time.LocalDate;
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
            match.setDate(Date.valueOf(substring));
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

    @Test
    @DisplayName("일자별 결과 반영 확인")
    void changeMatchResult() {
        List<Match> allByDateAndHasMatchIsTrue = matchRepository.findAllByDate(2022, 10, 01);

        for (Match match : allByDateAndHasMatchIsTrue) {
            match.setMatchTeam1Score(1);
            match.setMatchTeam2Score(2);
        }
        System.out.println("allByDateAndHasMatchIsTrue.size() = " + allByDateAndHasMatchIsTrue.size());
        matchRepository.saveAll(allByDateAndHasMatchIsTrue);

    }

    @Test
    @DisplayName("자동 크롤링 테스트")
    void autoCrawlTest() {
        matchService.saveMatchList();
    }

    @Test
    @DisplayName("매치 결과 삽입(수정) 테스트")
    void modifyMatchResult() throws BaseException {
        Match match = matchService.modifyMatchResult(5568L, 2, 3);
        System.out.println(match);
    }
}