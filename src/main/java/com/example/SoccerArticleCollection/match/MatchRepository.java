package com.example.SoccerArticleCollection.match;

import com.example.SoccerArticleCollection.match.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    @Override
    <S extends Match> List<S> saveAll(Iterable<S> entities);

    @Override
    <S extends Match> S save(S entity);

    List<Match> findAllByHasMatchIsTrue();

    Optional<Match> findByMatchingId(Long matchId);

    @Query("SELECT m FROM Match m WHERE year(m.date) =?1 and month(m.date) =?2 and day(m.date) =?3")
    List<Match> findAllByDate(int year, int month,int day);

    @Query("SELECT m FROM Match m WHERE year(m.date) =?1 and month(m.date) =?2")
    List<Match> findAllByDate(int year, int month);

}
