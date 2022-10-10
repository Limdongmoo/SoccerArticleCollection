package com.example.SoccerArticleCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoccerArticleCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerArticleCollectionApplication.class, args);
	}

}
