package com.example.SoccerArticleCollection.match.model;

import com.example.SoccerArticleCollection.domain.article.Article;
import com.example.SoccerArticleCollection.domain.match.*;
import com.example.SoccerArticleCollection.repository.ArticleRepository;
import com.example.SoccerArticleCollection.repository.MatchRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
class MatchModelTest {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    @DisplayName("Match To GetMatchRes Test")
    void getMatchRes() {
        Optional<Match> byId = matchRepository.findById(8116L);
        Match match = byId.get();
        List<GetMatchRes> getMatchResList = new ArrayList<>();
        getMatchResList.add(GetHasMatchBeforeRes.from(match));
        System.out.println("getMatchResList.get(0) = " + getMatchResList.get(0));

    }

    @Test
    @DisplayName("Matches Parsing test")
    void getMatchesRes() {
        //given
        List<Match> matches = matchRepository.findAllByDate(2022,10);

        System.out.println("matches.size() = " + matches.size());
        //when
        List<GetMatchRes> collect = matches.stream()
                .map(match -> {
                    if (!match.isHasMatch()) {
                        return GetNotMatchRes.from(match);
                    } else {
                        if (match.getMatchWinner().equals("경기 전")) {
                            return GetHasMatchBeforeRes.from(match);
                        } else {
                            return GetHasMatchAfterRes.from(match);
                        }
                    }
                })
                .collect(Collectors.toList());

        collect.forEach(
                System.out::println
        );
    }

    @Test
    @DisplayName("Match 와 Article 매핑 관계 테스트")
    void matchAndArticleMappingTest() {
        Match match = new Match();
        Match save = matchRepository.save(match);

        Article article = new Article();
        articleRepository.save(article);

    }
}
