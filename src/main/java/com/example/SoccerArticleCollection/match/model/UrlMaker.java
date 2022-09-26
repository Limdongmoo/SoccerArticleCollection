package com.example.SoccerArticleCollection.match.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlMaker {
    private String year = "year=";
    private String month = "&month=";
    private String category ="&category=epl";

}
