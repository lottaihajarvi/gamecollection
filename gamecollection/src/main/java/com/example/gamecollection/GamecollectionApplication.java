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
import com.example.gamecollection.domain.User;
import com.example.gamecollection.domain.UserRepository;

@SpringBootApplication
public class GamecollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(GamecollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GamecollectionApplication.class, args);
	}
	
	@Bean
	// runs code when the SpringApplication is started
	public CommandLineRunner gamecollection(GameRepository gamerepository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of games");
			// demo genres to database
			grepository.save(new Genre("RPG"));
			grepository.save(new Genre("Simulation"));
			grepository.save(new Genre("Survival Horror"));
			
			// demo data to database
			gamerepository.save(new Game("FF7 Remake", "Square Enix", 2020, 64.95, "PS4", "100%", grepository.findByName("RPG").get(0)));
			gamerepository.save(new Game("RE2 Remake", "Capcom", 2019, 24.45, "PS4, Xbox, Windows", "25%", grepository.findByName("Survival Horror").get(0)));	
			gamerepository.save(new Game("Animal Crossing", "Nintendo", 2020, 50.00, "Nintendo Switch", "50%", grepository.findByName("Simulation").get(0)));
			
			User user1 = new User("random user", "$2y$12$cFlsVwevz2vI.R2NZ6LShul5uhVk4iE7lMdTUR9gGsijMXg5JsV.S", "USER");
			User user2 = new User("Lotta", "$2b$10$.Aply6F9ac2sL1NW3iTLbeWfUBtkciaEnidv79ltRmirlytV05qc.", "LOTTA");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all games");
			for (Game game : gamerepository.findAll()) {
				log.info(game.toString());
			}

		};
	}

}
