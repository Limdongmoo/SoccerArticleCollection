package com.example.SoccerArticleCollection.match.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchFromCrawler {
    private String date;
    private String matchInfo;
    private String matchName;
    private String matchLink;

    public MatchFromCrawler(String date, String matchInfo, String matchName, String matchLink) {
        this.date = date;
        this.matchInfo = matchInfo;
        this.matchName = matchName;
        this.matchLink = matchLink;
    }

    public static Match from(MatchFromCrawler match,String matchTeam1,int matchTeam1Score,String matchTeam2,int matchTeam2Score
                             ,String matchWinner) {
        return Match.builder()
                .date(match.getDate())
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
                .date(match.getDate())
                .matchTeam1(matchTeam1)
                .matchTeam2(matchTeam2)
                .matchInfo(match.getMatchInfo())
                .matchLink(match.getMatchLink())
                .build();
    }
}
