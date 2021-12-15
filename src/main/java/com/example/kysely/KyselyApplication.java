package com.example.kysely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.kysely.domain.Answer;
import com.example.kysely.domain.AnswerRepository;
import com.example.kysely.domain.Query;
import com.example.kysely.domain.QueryRepository;

@SpringBootApplication
public class KyselyApplication {
	
	@Autowired
	private QueryRepository queryrepo;
	
	@Autowired
	private AnswerRepository arepo;

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	
		
	
	
	@Bean

    CommandLineRunner runner(){
      return args -> {
        
    	  queryrepo.save(new Query("Avoin kysymys"));
    	  arepo.save(new Answer("a"));
    	  queryrepo.save(new Query("Radiokysymys"));
      };
    }

}
