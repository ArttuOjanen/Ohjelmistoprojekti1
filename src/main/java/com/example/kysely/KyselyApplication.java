package com.example.kysely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kysely.domain.Query;
import com.example.kysely.domain.QueryRepository;

@SpringBootApplication
public class KyselyApplication {
	
	@Autowired
	private QueryRepository queryrepo;

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean

    CommandLineRunner runner(){
      return args -> {
        
    	  queryrepo.save(new Query("Avoin kysymys"));
    	  queryrepo.save(new Query("Radiokysymys"));
      };
    }

}
