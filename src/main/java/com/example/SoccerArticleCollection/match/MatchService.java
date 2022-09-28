package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.match.model.Match;
import com.example.SoccerArticleCollection.match.model.SeleniumCrawler;
import com.example.SoccerArticleCollection.match.model.UrlMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        String[] years = {"2022", "2023"};
        String[] months = {"11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10"};

        UrlMaker urlMaker = new UrlMaker();
        List<Match> matches = new ArrayList<>();

//        for (String s : years) {
        urlMaker.setYear("year=" + "2022");
//            for (String s1 : months) {
        urlMaker.setMonth("&month=" + "11");
        matches.addAll(matchRepository.saveAll(seleniumCrawler.crawlSchedule(urlMaker)));
//            }
//
//        }


        return matches;

    }
}



