package com.example.Ohjelmistoprojekti1;



import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Ohjelmistoprojekti1.domain.AnswerRepository;
import com.example.Ohjelmistoprojekti1.domain.Query;
import com.example.Ohjelmistoprojekti1.domain.QueryRepository;
import com.example.Ohjelmistoprojekti1.domain.QuestionRepository;
import com.example.Ohjelmistoprojekti1.domain.Question;
import com.example.Ohjelmistoprojekti1.domain.Answer;



@SpringBootApplication
public class Ohjelmistoprojekti1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ohjelmistoprojekti1Application.class, args);
		
		
	}
	
	@Bean
	public CommandLineRunner queryDemo(QueryRepository queryRepository, QuestionRepository questionRepository, AnswerRepository arepository) {
		return (args) -> {
		
		Query query = new Query();
		//query.setName("Kysely");
		queryRepository.save(query);
		
			
			

		};
	}
		
}
