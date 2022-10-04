package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.match.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    @Override
    <S extends Match> List<S> saveAll(Iterable<S> entities);

    @Override
    <S extends Match> S save(S entity);

    List<Match> findAllByHasMatchIsTrue();

    List<Match> findAllByDateAndHasMatchIsTrue(String date);
}
