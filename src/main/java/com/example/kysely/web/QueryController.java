package com.example.kysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kysely.domain.Query;
import com.example.kysely.domain.QueryRepository;

@RestController
public class QueryController {
	
	@Autowired
	private QueryRepository queryrepo;

	@RequestMapping("/query")
	public Iterable<Query> getQuerys() {
		return queryrepo.findAll();
	}
}
