package com.example.SoccerArticleCollection.domain.match;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class MatchFromCrawler {
    private String matchInfo;
    private String matchName;
    private String matchLink;

    public MatchFromCrawler(String matchInfo, String matchName, String matchLink) {
        this.matchInfo = matchInfo;
        this.matchName = matchName;
        this.matchLink = matchLink;
    }

    public static Match from(MatchFromCrawler match,String matchTeam1,int matchTeam1Score,String matchTeam2,int matchTeam2Score
                             ,String matchWinner) {
        return Match.builder()
                .time(Time.valueOf(match.getMatchInfo().substring(0, 5) + ":00"))
                .matchTeam1(matchTeam1)
                .matchTeam1Score(matchTeam1Score)
                .matchTeam2(matchTeam2)
                .matchTeam2Score(matchTeam2Score)
                .matchWinner(matchWinner)
                .matchInfo(match.getMatchInfo())
                .matchLink(match.getMatchLink())
                .build();
    }

    public static Match from(MatchFromCrawler match,String matchTeam1,String matchTeam2) {
        return Match.builder()
                .time(Time.valueOf(match.getMatchInfo().substring(0, 5) + ":00"))
                .matchTeam1(matchTeam1)
                .matchTeam2(matchTeam2)
                .matchWinner("경기 전")
                .matchInfo(match.getMatchInfo())
                .matchLink(match.getMatchLink())
                .build();
    }
}
