package com.example.SoccerArticleCollection.service;

import com.example.SoccerArticleCollection.config.BaseException;
import com.example.SoccerArticleCollection.config.BaseResponseStatus;
import com.example.SoccerArticleCollection.domain.match.*;
import com.example.SoccerArticleCollection.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.SoccerArticleCollection.config.BaseResponseStatus.*;

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

    /**
     * 연도 + 월별 매치 조회 메소드
     * @param year (ex.2022)
     * @param month (ex.10)
     */
    public List<GetMatchRes> getAllMatchByYearAndMonth(int year, int month) throws BaseException{
        try {
            List<Match> allByDate = matchRepository.findAllByDate(year, month);
            return allByDate.stream()
                    .map(match -> {
                        if (!match.isHasMatch()) {
                            return GetNotMatchRes.from(match);
                        } else {
                            if (match.getMatchWinner().equals("경기 전")) {
                                return GetHasMatchBeforeRes.from(match);
                            } else {
                                return GetHasMatchAfterRes.from(match);
                            }
                        }
                    }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_GET_MATCHES_SERVER_ERROR);
        }
    }

    /**
     * 매치 결과 입력 (수정) 메소드
     */
    public Match modifyMatchResult(PatchMatchResultReq patchMatchResultReq) throws BaseException{
        Optional<Match> byMatchingId = matchRepository.findByMatchingId(patchMatchResultReq.getMatchingId());
        if (byMatchingId.isEmpty()) {
            throw new BaseException(FAILED_TO_GET_MATCH_SERVER_ERROR);
        }
        try {
            Match match = byMatchingId.get();
            int team1Score = patchMatchResultReq.getTeam1Score();
            match.setMatchTeam1Score(team1Score);
            int team2Score = patchMatchResultReq.getTeam2Score();
            match.setMatchTeam2Score(team2Score);
            String winner;
            if (team1Score == team2Score) {
                winner = "무승부";
            } else {
                winner = (team1Score > team2Score) ? match.getMatchTeam1() : match.getMatchTeam2();
            }
            match.setMatchWinner(winner);

            return matchRepository.save(match);
        } catch (Exception e) {
            throw new BaseException(FAILED_TO_MODIFY_MATCH_RESULT_IN_SERVER);
        }

    }
}
