package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.match.model.Match;
import com.example.SoccerArticleCollection.match.model.MatchCrawler;
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

        String[] years = {"2022", "2023"};
        String[] months = {"08","09","10","11","12","01","02","03","04","05"};

        UrlMaker urlMaker = new UrlMaker();
        List<Match> matches = new ArrayList<>();
        int sequence = 0;
        for (String s : years) {
            urlMaker.setYear("year=" + s);
            for (int i = sequence; i < months.length; i++) {
                if(months[sequence].equals("01")&&s.equals("2022")){
                    break;
                }
                MatchCrawler matchCrawler = new MatchCrawler();
                urlMaker.setMonth("&month=" + months[sequence++]);
                List<Match> matches1 = matchCrawler.crawlSchedule(urlMaker);
                matches = matchRepository.saveAll(matches1);
            }

        }

        return matches;
    }

    public List<Match> findAll() {
        return matchRepository.findAll();
    }
}



