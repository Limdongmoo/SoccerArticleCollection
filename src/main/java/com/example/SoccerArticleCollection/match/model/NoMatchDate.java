package com.example.SoccerArticleCollection.match.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class NoMatchDate extends Match {

    private final String content = "경기 일정이 없습니다.";

    public NoMatchDate(String date) {
        super(date);
    }

    @Override
    public String toString() {
        return "NoMatchDate{" + this.date +
                "Date='"  + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
