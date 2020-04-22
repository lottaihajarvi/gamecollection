package com.example.gamecollection.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gamecollection.domain.Game;
import com.example.gamecollection.domain.GameRepository;
import com.example.gamecollection.domain.GenreRepository;


@Controller
public class GameController {
	
		// brings repository
		// injects dependency at run-time by spring
		@Autowired
		private GameRepository repository;
		
		 // brings genre repository
		@Autowired
		private GenreRepository grepository;
		
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		} 
		
		// RESTful service to get all tasks
	    @RequestMapping(value="/games", method = RequestMethod.GET) // returns games as JSON format
	    public @ResponseBody List<Game> gameListRest() {	
	        return (List<Game>) repository.findAll();
	    }    

		// RESTful service to find game by id
	    @RequestMapping(value="/game/{id}", method = RequestMethod.GET) 
	    public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long gameId) {	
	    	return repository.findById(gameId);
	    }
		
		// shows all games. handles GET request from endpoint /gamelist
		@RequestMapping(value= {"/", "/gamelist"})
	    public String gameList(Model model) {	
			model.addAttribute("games", repository.findAll()); // findAll() -> all games are fetched from the database and added to the model attribute
	        return "gamelist";
	    }
		
		// save new game
		@RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Game game){
	        repository.save(game);
	        return "redirect:gamelist";
	    }
		
		// add new game
	    @RequestMapping(value = "/add") // endpoint
	    public String addGame(Model model){
	    	model.addAttribute("game", new Game());
	    	model.addAttribute("genres", grepository.findAll()); // findAll() -> all games are fetched from the database and added to the model attribute
	    															// "genres" adds dropdown list of the genres to form
	        return "addgame";
		
	    }
	    
	    // edit game
	    @PreAuthorize("hasAuthority('LOTTA')") // secures method to user LOTTA
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    // retrieves a game with an sql statement from the database with this id
		 public String editGame(@PathVariable("id") Long gameId, Model model) { // contains edited object instead of empty object
			model.addAttribute("game", repository.findById(gameId));
			model.addAttribute("genres", grepository.findAll()); // findAll() -> all games are fetched from the database and added to the model attribute
																	// "genres" adds dropdown list of the genress to form
			return "editgame";
	  }
	    
	    // delete game
	    @PreAuthorize("hasAuthority('LOTTA')") // secures method to user LOTTA
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) // handles /delete/gameid endpoint
	    public String deleteGame(@PathVariable("id") Long gameId, Model model) { // @PathVariable extracts id from the URI
	    	repository.deleteById(gameId);
	        return "redirect:../gamelist"; 
	    }

}
