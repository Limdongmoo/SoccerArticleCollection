package com.example.SoccerArticleCollection.domain.match;

import com.example.SoccerArticleCollection.domain.article.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "MatchSchedule")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_id")
    private Long matchingId;

    @Column(name = "match_date")
    private Date date;

    @Column(name = "hasMatch")
    private boolean hasMatch;

    @Column(name = "text")
    private String text;

    @Column(name = "match_team1")
    private String matchTeam1;

    @Column(name = "match_team1_score")
    private int matchTeam1Score;

    @Column(name = "match_team2")
    private String matchTeam2;

    @Column(name = "match_team2_score")
    private int matchTeam2Score;

    @Column(name = "match_winner")
    private String matchWinner;

    @Column(name = "match_info")
    private String matchInfo;

    @Column(name = "match_link")
    private String matchLink;

    @Builder
    public Match(Date date, String matchTeam1, int matchTeam1Score, String matchTeam2, int matchTeam2Score,
                 String matchWinner, String matchInfo, String matchLink) {
        this.hasMatch = true;
        this.date = date;
        this.matchTeam1 = matchTeam1;
        this.matchTeam1Score = matchTeam1Score;
        this.matchTeam2 = matchTeam2;
        this.matchTeam2Score = matchTeam2Score;
        this.matchWinner = matchWinner;
        this.matchInfo = matchInfo;
        this.matchLink = matchLink;
    }

    public Match(Date date) {
        this.date = date;
        this.hasMatch = false;
        this.text = "경기 일정이 존재하지 않습니다.";
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchingId=" + matchingId +
                ", date='" + date + '\'' +
                ", hasMatch=" + hasMatch +
                ", text='" + text + '\'' +
                ", matchTeam1='" + matchTeam1 + '\'' +
                ", matchTeam1Score=" + matchTeam1Score +
                ", matchTeam2='" + matchTeam2 + '\'' +
                ", matchTeam2Score=" + matchTeam2Score +
                ", matchWinner='" + matchWinner + '\'' +
                ", matchInfo='" + matchInfo + '\'' +
                ", matchLink='" + matchLink + '\'' +
                '}';
    }
}
