package com.siteinvokers.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siteinvokers.quizapp.model.Question;
import com.siteinvokers.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionConntroller {

	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return questionService.getAllQuestions();
	}

	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}

	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		System.out.println("Controller : " + question.toString());
		return questionService.addQuestion(question);
	}

	@DeleteMapping("question/{questionId}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable int questionId){
		return questionService.deleteQuestionById(questionId) ;
	}

	@PutMapping("update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
		System.out.println("Controller : " + question.toString());
		return questionService.addQuestion(question);
	}


}
