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
import com.example.gamecollection.domain.Kayttaja;
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
			grepository.save(new Genre("Action-Adventure"));
			grepository.save(new Genre("Survival Horror"));
			grepository.save(new Genre("Simulation"));
			
			// demo data to database
			gamerepository.save(new Game("DQXI", "Square Enix", 2017, 62.95, "PS4", "100%", grepository.findByName("RPG").get(0)));
			gamerepository.save(new Game("Shadow of the Colossus", "Team Ico", 2018, 24.45, "PS4", "100%", grepository.findByName("Action-Adventure").get(0)));	
			gamerepository.save(new Game("Breath of the Wild", "Nintendo", 2017, 70.00, "Nintendo Switch", "98%", grepository.findByName("Action-Adventure").get(0)));
			gamerepository.save(new Game("RE1 Remake", "Capcom", 2002, 15.00, "PS4", "64%", grepository.findByName("Survival Horror").get(0))); 
			
			// creates and saves user and admin
			Kayttaja user1 = new Kayttaja("random user", "$2y$12$cFlsVwevz2vI.R2NZ6LShul5uhVk4iE7lMdTUR9gGsijMXg5JsV.S", "USER");
			Kayttaja user2 = new Kayttaja("Lotta", "$2b$10$.Aply6F9ac2sL1NW3iTLbeWfUBtkciaEnidv79ltRmirlytV05qc.", "LOTTA");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all games");
			for (Game game : gamerepository.findAll()) {
				log.info(game.toString());
			}

		};
	}

}
