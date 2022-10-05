package com.example.SoccerArticleCollection.domain.match;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
public class GetHasMatchBeforeRes extends GetMatchRes{

    private Long matchId;
    private Date date;
    private String matchInfo;
    private String matchLink;
    private String matchTeam1;
    private String matchTeam2;
    private boolean hasMatch;


    @Builder
    public GetHasMatchBeforeRes(Long matchId, Date date, String matchInfo,String matchLink,
                                String matchTeam1,String matchTeam2,boolean hasMatch) {
        this.matchId = matchId;
        this.date = date;
        this.matchInfo = matchInfo;
        this.matchLink = matchLink;
        this.matchTeam1 = matchTeam1;
        this.matchTeam2 = matchTeam2;
        this.hasMatch = hasMatch;

    }

    public static GetHasMatchBeforeRes from(Match match) {
        return GetHasMatchBeforeRes.builder()
                .matchId(match.getMatchingId())
                .date(match.getDate())
                .matchInfo(match.getMatchInfo())
                .matchLink(match.getMatchLink())
                .matchTeam1(match.getMatchTeam1())
                .matchTeam2(match.getMatchTeam2())
                .hasMatch(match.isHasMatch())
                .build();
    }

    @Override
    public String toString() {
        return "GetHasMatchBeforeRes{" +
                "matchId=" + matchId +
                ", date=" + date +
                ", matchInfo='" + matchInfo + '\'' +
                ", matchLink='" + matchLink + '\'' +
                ", matchTeam1='" + matchTeam1 + '\'' +
                ", matchTeam2='" + matchTeam2 + '\'' +
                ", hasMatch=" + hasMatch +
                '}';
    }
}
