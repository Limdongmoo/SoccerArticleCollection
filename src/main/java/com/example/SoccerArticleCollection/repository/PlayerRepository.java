package com.example.SoccerArticleCollection.repository;

import com.example.SoccerArticleCollection.domain.player.RankType;
import com.example.SoccerArticleCollection.domain.player.TopPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<TopPlayer, Long> {
    @Override
    <S extends TopPlayer> List<S> saveAll(Iterable<S> entities);

    void deleteAllByRankType(RankType rankType);


}
