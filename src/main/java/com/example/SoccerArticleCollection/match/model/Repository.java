package com.example.SoccerArticleCollection.match.model;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@org.springframework.stereotype.Repository
public class Repository {

    private final JdbcTemplate jdbcTemplate;

    public Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
