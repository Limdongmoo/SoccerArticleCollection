package com.example.SoccerArticleCollection.player.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "TopPlayer")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private RankType rankType;

    @Column
    private int rank;

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
    private int goalConversion;

    @Column
    private int shotAccuracy;

    @Column
    private int chancesCreated;

    @Column
    private int chancesPer90;

    @Column
    private int totalPasses;

    @Column
    private int chancesComplete;

    @Column
    private int chancesIncomplete;

    @Column
    private int passAccuracy;


    public Player(int rank, int goals, int assists, int played, Double goalsPer90, int minsPerGoal, int totalShots,
                  int goalConversion, int shotAccuracy) {
        this.rankType = RankType.SCORE;
        this.rank = rank;
        this.goals = goals;
        this.assists = assists;
        this.played = played;
        this.goalsPer90 = goalsPer90;
        this.minsPerGoal = minsPerGoal;
        this.totalShots = totalShots;
        this.goalConversion = goalConversion;
        this.shotAccuracy = shotAccuracy;
    }

    public Player(int rank, int goals, int assists, int played, int chancesCreated, int chancesPer90, int totalPasses,
                  int chancesComplete, int chancesIncomplete, int passAccuracy) {
        this.rankType = RankType.ASSISTS;
        this.rank = rank;
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
}
