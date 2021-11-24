package com.example.Ohjelmistoprojekti1.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Ohjelmistoprojekti1.domain.Answer;
import com.example.Ohjelmistoprojekti1.domain.AnswerRepository;
import com.example.Ohjelmistoprojekti1.domain.Query;
import com.example.Ohjelmistoprojekti1.domain.QueryRepository;
import com.example.Ohjelmistoprojekti1.domain.Question;
import com.example.Ohjelmistoprojekti1.domain.QuestionRepository;

@Controller
public class QueryController {
	
	@Autowired
	private QueryRepository qrepository;
	
	@Autowired
	private AnswerRepository arepository;
	
	@Autowired
	private QuestionRepository questrepo;

	@CrossOrigin
	@GetMapping("/test")
	public @ResponseBody List<Query> allquestions() {
		return (List<Query>) qrepository.findAll();
	}
	
	@PostMapping("/test")
	Query newQuery(@RequestBody Query newQuery) {
		return qrepository.save(newQuery);
	}
	
	@RequestMapping(value="/querylist")
    public String questionList(Model model) {	
        model.addAttribute("queries", qrepository.findAll());
        return "test";
    }
	
	@PostMapping("/saveanswer")
	Answer newAnswer(@RequestBody Answer newAnswer) {
		return arepository.save(newAnswer);
	}
	
	@GetMapping("/atest")
	public @ResponseBody List<Answer> allanswers() {
		return (List<Answer>) arepository.findAll();
	}
	
	@GetMapping("/test")
	public @ResponseBody List<Question> questions() {
		return (List<Question>) questrepo.findAll();
	}
	
	@PostMapping("/test")
	Question newQuestion(@RequestBody Question newQuestion) {
		return questrepo.save(newQuestion);
	}
}