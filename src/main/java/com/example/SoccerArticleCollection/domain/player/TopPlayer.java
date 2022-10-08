package com.example.SoccerArticleCollection.domain.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "TopPlayer")
public class TopPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column
    @Enumerated(EnumType.STRING)
    private RankType rankType;

    @Column
    private String name;

    @Column
    private String team;

    @Column
    private int ranking;

    @Column
    private int goals;

    @Column
    private int assists;

    @Column
    private int played;

    @Column
    private Double goalsPer90;

    @Column
    private int minsPerGoal;

    @Column
    private int totalShots;

    @Column
    private String goalConversion;

    @Column
    private String shotAccuracy;

    @Column
    private int chancesCreated;

    @Column
    private Double chancesPer90;

    @Column
    private int totalPasses;

    @Column
    private int chancesComplete;

    @Column
    private int chancesIncomplete;

    @Column
    private String passAccuracy;

    @Builder(builderClassName = "GoalRankingBuilder" , builderMethodName = "GoalRankingBuilder")
    public TopPlayer(String name, String team, int ranking, int goals, int assists, int played, Double goalsPer90, int minsPerGoal, int totalShots,
                     String goalConversion, String shotAccuracy) {
        this.name = name;
        this.team = team;
        this.rankType = RankType.SCORE;
        this.ranking = ranking;
        this.goals = goals;
        this.assists = assists;
        this.played = played;
        this.goalsPer90 = goalsPer90;
        this.minsPerGoal = minsPerGoal;
        this.totalShots = totalShots;
        this.goalConversion = goalConversion;
        this.shotAccuracy = shotAccuracy;
    }

    @Builder(builderClassName = "AssistsRankingBuilder" , builderMethodName = "AssistsRankingBuilder")
    public TopPlayer(String name, String team, int ranking, int goals, int assists, int played, int chancesCreated, Double chancesPer90, int totalPasses,
                     int chancesComplete, int chancesIncomplete, String passAccuracy) {
        this.rankType = RankType.ASSISTS;
        this.name = name;
        this.team = team;
        this.ranking = ranking;
        this.goals = goals;
        this.assists = assists;
        this.played = played;
        this.chancesCreated = chancesCreated;
        this.chancesPer90 = chancesPer90;
        this.totalPasses = totalPasses;
        this.chancesComplete = chancesComplete;
        this.chancesIncomplete = chancesIncomplete;
        this.passAccuracy = passAccuracy;
    }

    @Override
    public String toString() {
        return "TopPlayer{" +
                "playerId=" + playerId +
                ", rankType=" + rankType +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", ranking=" + ranking +
                ", goals=" + goals +
                ", assists=" + assists +
                ", played=" + played +
                ", goalsPer90=" + goalsPer90 +
                ", minsPerGoal=" + minsPerGoal +
                ", totalShots=" + totalShots +
                ", goalConversion='" + goalConversion + '\'' +
                ", shotAccuracy='" + shotAccuracy + '\'' +
                ", chancesCreated=" + chancesCreated +
                ", chancesPer90=" + chancesPer90 +
                ", totalPasses=" + totalPasses +
                ", chancesComplete=" + chancesComplete +
                ", chancesIncomplete=" + chancesIncomplete +
                ", passAccuracy='" + passAccuracy + '\'' +
                '}';
    }
}
