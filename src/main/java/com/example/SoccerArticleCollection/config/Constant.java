package com.example.SoccerArticleCollection.config;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Constant {

    // BBC 프리미어 리그 링크
    public static final String BBC_PREMIER_LEAGUE_URL = "https://www.bbc.com/sport/football/premier-league";

    // BBC 프리미어 리그 링크
    public static final String BBC_PREMIER_LEAGUE_TEAM_URL = "https://www.bbc.com/sport/football/teams/";

    public static final String SKY_SPORTS_PREMIER_LEAGUE_URL = "https://www.skysports.com/premier-league";

    // Naver 오픈톡 링크
    public static final String NAVER_OPEN_TALK_URL = "https://m.sports.naver.com/community/opentalk/index";


    // 팀별 영어 이름
    public static final Map<String, String> team
            = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("아스널", "Arsenal"),
            new AbstractMap.SimpleEntry<>("리버풀", "Liverpool"),
            new AbstractMap.SimpleEntry<>("아스톤 빌라", "Aston Villa"),
            new AbstractMap.SimpleEntry<>("울버햄튼", "Wolverhampton Wanderers"),
            new AbstractMap.SimpleEntry<>("노팅엄 포레스트", "Nottingham Forest"),
            new AbstractMap.SimpleEntry<>("사우샘프턴", "Southampton"),
            new AbstractMap.SimpleEntry<>("첼시", "Chelsea"),
            new AbstractMap.SimpleEntry<>("브렌트포드", "Brentford"),
            new AbstractMap.SimpleEntry<>("브라이튼", "Brighton & Hove Albion"),
            new AbstractMap.SimpleEntry<>("맨시티", "Manchester City"),
            new AbstractMap.SimpleEntry<>("에버턴", "Everton"),
            new AbstractMap.SimpleEntry<>("레스터", "Leicester City"),
            new AbstractMap.SimpleEntry<>("뉴캐슬", "Newcastle United"),
            new AbstractMap.SimpleEntry<>("본머스", "Bournemouth"),
            new AbstractMap.SimpleEntry<>("리즈", "Leeds United"),
            new AbstractMap.SimpleEntry<>("풀럼", "Fulham"),
            new AbstractMap.SimpleEntry<>("맨유", "Manchester United"),
            new AbstractMap.SimpleEntry<>("웨스트햄", "West Ham United"),
            new AbstractMap.SimpleEntry<>("토트넘", "Tottenham Hotspur"),
            new AbstractMap.SimpleEntry<>("펠리스", "Crystal Palace")
    );


}
