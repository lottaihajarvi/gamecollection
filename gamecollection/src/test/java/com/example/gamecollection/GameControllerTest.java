package com.example.gamecollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gamecollection.web.GameController;

// smoke testing that the context is creating the controller
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameControllerTest {
	
	@Autowired
	private GameController controller;

	@Test // defines a method to be test method
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

} // test case successful
