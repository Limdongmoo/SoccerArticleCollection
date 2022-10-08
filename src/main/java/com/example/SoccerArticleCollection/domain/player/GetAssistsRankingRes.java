package com.example.SoccerArticleCollection.domain.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAssistsRankingRes {

    private int ranking;
    private String name;
    private String team;
    private int assists;
    private int goals;
    private int played;
    private int chancesCreated;
    private double chancesPer90;
    private int totalPasses;
    private int passesComplete;
    private int passesIncomplete;
    private String passAccuracy;

    @Builder
    public GetAssistsRankingRes(int ranking, String name, String team, int assists, int goals, int played,
                                int chancesCreated, double chancesPer90, int totalPasses, int passesComplete,
                                int passesIncomplete, String passAccuracy) {
        this.ranking = ranking;
        this.name = name;
        this.team = team;
        this.assists = assists;
        this.goals = goals;
        this.played = played;
        this.chancesCreated = chancesCreated;
        this.chancesPer90 = chancesPer90;
        this.totalPasses = totalPasses;
        this.passesComplete = passesComplete;
        this.passesIncomplete = passesIncomplete;
        this.passAccuracy = passAccuracy;
    }

    public static GetAssistsRankingRes from(TopPlayer topPlayer) {

        return GetAssistsRankingRes.builder()
                .ranking(topPlayer.getRanking())
                .name(topPlayer.getName())
                .team(topPlayer.getTeam())
                .assists(topPlayer.getAssists())
                .goals(topPlayer.getGoals())
                .played(topPlayer.getPlayed())
                .chancesCreated(topPlayer.getChancesCreated())
                .chancesPer90(topPlayer.getChancesPer90())
                .totalPasses(topPlayer.getTotalPasses())
                .passesComplete(topPlayer.getChancesComplete())
                .passesIncomplete(topPlayer.getChancesIncomplete())
                .passAccuracy(topPlayer.getPassAccuracy())
                .build();
    }

    @Override
    public String toString() {
        return "GetAssistsRankingRes{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", assists=" + assists +
                ", goals=" + goals +
                ", played=" + played +
                ", chancesCreated=" + chancesCreated +
                ", chancesPer90=" + chancesPer90 +
                ", totalPasses=" + totalPasses +
                ", passesComplete=" + passesComplete +
                ", passesIncomplete=" + passesIncomplete +
                ", passAccuracy='" + passAccuracy + '\'' +
                '}';
    }
}
