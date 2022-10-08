package com.example.SoccerArticleCollection.domain.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetScoreRankingRes {

    private int ranking;
    private String name;
    private String team;
    private int goals;
    private int assists;
    private int played;
    private double goalsPer90;
    private int minPerGoal;
    private String goalConversion;
    private String shotAccuracy;

    @Builder
    public GetScoreRankingRes(int ranking, String name, String team, int goals, int assists, int played,
                              double goalsPer90, int minPerGoal, String goalConversion, String shotAccuracy) {
        this.ranking = ranking;
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
        this.played = played;
        this.goalsPer90 = goalsPer90;
        this.minPerGoal = minPerGoal;
        this.goalConversion = goalConversion;
        this.shotAccuracy = shotAccuracy;
    }

    public static GetScoreRankingRes from(TopPlayer topPlayer) {

        return GetScoreRankingRes.builder()
                .ranking(topPlayer.getRanking())
                .name(topPlayer.getName())
                .team(topPlayer.getTeam())
                .goals(topPlayer.getGoals())
                .assists(topPlayer.getAssists())
                .played(topPlayer.getPlayed())
                .goalsPer90(topPlayer.getGoalsPer90())
                .minPerGoal(topPlayer.getMinsPerGoal())
                .goalConversion(topPlayer.getGoalConversion())
                .shotAccuracy(topPlayer.getShotAccuracy())
                .build();
    }

    @Override
    public String toString() {
        return "GetScoreRankingRes{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", goals=" + goals +
                ", assists=" + assists +
                ", played=" + played +
                ", goalsPer90=" + goalsPer90 +
                ", minPerGoal=" + minPerGoal +
                ", goalConversion='" + goalConversion + '\'' +
                ", shotAccuracy='" + shotAccuracy + '\'' +
                '}';
    }
}
