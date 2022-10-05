package com.example.SoccerArticleCollection.domain.match;

import lombok.Builder;

import java.sql.Date;

public class GetHasMatchAfterRes extends GetMatchRes{

    private Long matchId;
    private Date date;
    private String matchInfo;
    private String matchLink;
    private String matchTeam1;
    private int matchTeam1Score;
    private String matchTeam2;
    private int matchTeam2Score;
    private String matchWinner;
    private boolean hasMatch;

    @Builder
    public GetHasMatchAfterRes(Long matchId, Date date, String matchInfo, String matchLink, String matchTeam1,
                               int matchTeam1Score, String matchTeam2, int matchTeam2Score, String matchWinner, boolean hasMatch) {
        this.matchId = matchId;
        this.date = date;
        this.matchInfo = matchInfo;
        this.matchLink = matchLink;
        this.matchTeam1 = matchTeam1;
        this.matchTeam1Score = matchTeam1Score;
        this.matchTeam2 = matchTeam2;
        this.matchTeam2Score = matchTeam2Score;
        this.matchWinner = matchWinner;
        this.hasMatch = hasMatch;
    }

    public static GetHasMatchAfterRes from(Match match) {
        return GetHasMatchAfterRes.builder()
                .matchId(match.getMatchingId())
                .date(match.getDate())
                .matchInfo(match.getMatchInfo())
                .matchLink(match.getMatchLink())
                .matchTeam1(match.getMatchTeam1())
                .matchTeam1Score(match.getMatchTeam1Score())
                .matchTeam2(match.getMatchTeam2())
                .matchTeam2Score(match.getMatchTeam2Score())
                .matchWinner(match.getMatchWinner())
                .hasMatch(match.isHasMatch())
                .build();
    }

    @Override
    public String toString() {
        return "GetHasMatchAfterRes{" +
                "matchId=" + matchId +
                ", date=" + date +
                ", matchInfo='" + matchInfo + '\'' +
                ", matchLink='" + matchLink + '\'' +
                ", matchTeam1='" + matchTeam1 + '\'' +
                ", matchTeam1Score=" + matchTeam1Score +
                ", matchTeam2='" + matchTeam2 + '\'' +
                ", matchTeam2Score=" + matchTeam2Score +
                ", matchWinner='" + matchWinner + '\'' +
                ", hasMatch=" + hasMatch +
                '}';
    }
}
