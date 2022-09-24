package com.example.SoccerArticleCollection.match.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExistMatch extends Match {
    private String Date;
    private String matchInfo;
    private String matchName;
    private String matchLink;

    public ExistMatch(String date, String matchInfo, String matchName, String matchLink) {
        Date = date;
        this.matchInfo = matchInfo;
        this.matchName = matchName;
        this.matchLink = matchLink;
    }

    @Override
    public String toString() {
        return "ExistMatch{" +
                "Date='" + Date + '\'' +
                ", matchInfo='" + matchInfo + '\'' +
                ", matchName='" + matchName + '\'' +
                ", matchLink='" + matchLink + '\'' +
                '}';
    }
}
