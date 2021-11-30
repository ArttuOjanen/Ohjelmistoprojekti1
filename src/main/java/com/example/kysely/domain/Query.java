package com.example.kysely.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Query {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String question;
	
	public Query() {}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Query(String question) {
		super();
		this.question = question;
	}
	
	
}
