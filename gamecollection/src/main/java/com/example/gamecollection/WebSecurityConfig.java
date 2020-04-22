package com.example.gamecollection;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.gamecollection.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity // enables spring security web security support
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { // configures spring security
    
	@Autowired
	// spring security configuration uses UserDetailService implementation
    private UserDetailServiceImpl userDetailsService;  
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
    	// define URL paths to be secured 
    	http
		.authorizeRequests()
			.antMatchers("/", "/gamelist").permitAll() // does not require authentication
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
}
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        // encrypts passwords using Bcrypt hash algorithm
    }
    
    // create in-memory users for testing and demo purposes
    //@Bean
    //@Override
    //public UserDetailsService userDetailsService() {
        //List<UserDetails> users = new ArrayList();
    	//UserDetails user = User.withDefaultPasswordEncoder()
                //.username("random user")
                //.password("user")
                //.roles("USER")
                //.build();

    	//users.add(user);
    	
    	//user = User.withDefaultPasswordEncoder()
                   //.username("Lotta")
                  //.password("admin")
                   //.roles("LOTTA")
                   //.build();
    	
    	//users.add(user);
    	
        //return new InMemoryUserDetailsManager(users);
    //}
}
