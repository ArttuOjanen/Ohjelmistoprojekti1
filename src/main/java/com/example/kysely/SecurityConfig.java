package com.example.kysely;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Bean
	  @Override
	  public UserDetailsService userDetailsService() {
		UserDetails user =
	           User.withDefaultPasswordEncoder()
	              .username("user")
	              .password("password")
	              .roles("USER")
	              .build();

	      return new InMemoryUserDetailsManager(user);
	  }
	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        UrlBasedCorsConfigurationSource source = 
	            new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowedOrigins(Arrays.asList("*"));
	        config.setAllowedMethods(Arrays.asList("*"));
	        config.setAllowedHeaders(Arrays.asList("*"));
	        config.setAllowCredentials(false);
	        config.applyPermitDefaultValues();
	        
	        source.registerCorsConfiguration("/**", config);
	        return source;
	  }
   
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	   // Add this row to allow access to all endpoints
	   http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll();
	   
	   
	   
	   
  }
  
 
}

