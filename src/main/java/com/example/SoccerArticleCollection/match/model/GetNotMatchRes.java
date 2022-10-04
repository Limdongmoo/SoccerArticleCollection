package com.example.SoccerArticleCollection.match.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class GetNotMatchRes extends GetMatchRes{
    private Long matchingId;
    private Date date;
    private String text;
    private boolean hasMatch;

    @Builder
    public GetNotMatchRes(Long matchingId, Date date, String text, boolean hasMatch) {
        this.matchingId = matchingId;
        this.date = date;
        this.text = text;
        this.hasMatch = hasMatch;
    }

    public static GetNotMatchRes from(Match match) {
        return GetNotMatchRes.builder()
                .matchingId(match.getMatchingId())
                .date(match.getDate())
                .text(match.getText())
                .hasMatch(match.isHasMatch())
                .build();
    }

    @Override
    public String toString() {
        return "GetNotMatchRes{" +
                "matchingId=" + matchingId +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", hasMatch=" + hasMatch +
                '}';
    }
}
