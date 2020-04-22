package com.example.gamecollection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gamecollection.domain.Game;
import com.example.gamecollection.domain.GameRepository;
import com.example.gamecollection.domain.Genre;

//test class for jpa repository
@RunWith(SpringRunner.class) // 
@DataJpaTest // configures in-memory database, jPA and spring data
public class GameRepositoryTest { 

    @Autowired
    private GameRepository repository;

    @Test // defines a method to be test method
    public void findByTitleShouldReturnGame() {
        List<Game> games = repository.findByTitle("DQXI");
        
        assertThat(games).hasSize(1);
        assertThat(games.get(0).getTitle()).isEqualTo("DQXI");
    }
    
    @Test // defines a method to be test method
    public void createNewGame() {
    	Game game = new Game("Death Stranding", "Kojima Productions", 2019, 54.00, "PS4", "Queue", new Genre("Action"));
    	repository.save(game);
    	assertThat(game.getId()).isNotNull();
    }    

} // test case successful
