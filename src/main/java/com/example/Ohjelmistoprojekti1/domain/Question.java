package com.example.Ohjelmistoprojekti1.domain;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	public void setQuery(Query query2) {
		// TODO Auto-generated method stub
		
	}

	public void setQuestion(String quest) {
		// TODO Auto-generated method stub
		
	}

}
