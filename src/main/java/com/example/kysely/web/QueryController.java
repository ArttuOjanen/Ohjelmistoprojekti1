package com.example.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kysely.domain.Answer;
import com.example.kysely.domain.AnswerRepository;
import com.example.kysely.domain.Query;
import com.example.kysely.domain.QueryRepository;


@RestController
@RequestMapping("/api")
public class QueryController {
	
	@Autowired
	private QueryRepository queryrepo;
	
	@Autowired
	private AnswerRepository arepo;

	@GetMapping("/api")
	public Iterable<Query> getQuerys() {
		return queryrepo.findAll();
	}
	
	@GetMapping("/answers")
	public Iterable<Answer> getAnswers() {
		return arepo.findAll();
	}
	
	@PostMapping("/answers")
	public Iterable<Answer> save(Answer answer) {
		arepo.save(answer);
		return arepo.findAll();
}

}
