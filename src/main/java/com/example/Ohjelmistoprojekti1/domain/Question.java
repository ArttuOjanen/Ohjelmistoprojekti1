package com.example.Ohjelmistoprojekti1.domain;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Question {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	private String question;
	
	@ManyToOne
	private Query query;
	
	@JsonIgnore
	@OneToMany(mappedBy = "question")
	private List<Answer> answers = new ArrayList<>();

}
