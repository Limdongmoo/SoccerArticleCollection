package com.example.SoccerArticleCollection.domain.article;

import com.example.SoccerArticleCollection.domain.match.Match;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column
    private String title;

    @Column
    private String team1;

    @Column
    private String team2;

    @Column
    private String articleLink;

    @JoinColumn(name = "matching_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

}
