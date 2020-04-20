package com.example.gamecollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.gamecollection.domain.Game;
import com.example.gamecollection.domain.GameRepository;
import com.example.gamecollection.domain.Genre;
import com.example.gamecollection.domain.GenreRepository;

@SpringBootApplication
public class GamecollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(GamecollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GamecollectionApplication.class, args);
	}
	
	@Bean
	// runs code when the SpringApplication is started
	public CommandLineRunner gamecollection(GameRepository repository, GenreRepository grepository) {
		return (args) -> {
			log.info("save a couple of games");
			// demo genres to database
			grepository.save(new Genre("RPG"));
			grepository.save(new Genre("Simulation"));
			grepository.save(new Genre("Survival Horror"));
			
			// demo data to database
			repository.save(new Game("FF7 Remake", "Square Enix", 2020, 64.95, "PS4", "100%", grepository.findByName("RPG").get(0)));
			repository.save(new Game("RE2 Remake", "Capcom", 2019, 24.45, "PS4, Xbox, Windows", "25%", grepository.findByName("Survival Horror").get(0)));	
			repository.save(new Game("Animal Crossing", "Nintendo", 2020, 50.00, "Nintendo Switch", "50%", grepository.findByName("Simulation").get(0)));
			
			log.info("fetch all games");
			for (Game game : repository.findAll()) {
				log.info(game.toString());
			}

		};
	}

}
