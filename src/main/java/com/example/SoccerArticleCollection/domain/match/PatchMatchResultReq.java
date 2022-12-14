package com.example.SoccerArticleCollection.domain.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatchMatchResultReq {
    private Long matchingId;
    private int team1Score;
    private int team2Score;
}
