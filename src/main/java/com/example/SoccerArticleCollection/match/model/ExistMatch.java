package com.example.SoccerArticleCollection.match.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ExistMatch extends Match {
    private String matchInfo;
    private String matchName;
    private String matchLink;

    public ExistMatch(String date, String matchInfo, String matchName, String matchLink) {
        super(date);
        this.matchInfo = matchInfo;
        this.matchName = matchName;
        this.matchLink = matchLink;
    }

    @Override
    public String toString() {
        return "ExistMatch{" +
                "date='" + '\'' + this.date +
                ", matchInfo='" + matchInfo + '\'' +
                ", matchName='" + matchName + '\'' +
                ", matchLink='" + matchLink + '\'' +
                '}';
    }
}
