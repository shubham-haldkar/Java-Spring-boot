package com.siteinvokers.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.siteinvokers.quizapp.DAO.QuestionDAO;
import com.siteinvokers.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		System.out.println(questionDao.findAll());
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try{
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {	
		try{
		questionDao.save(question) ;	
		return new ResponseEntity<String>("Success" , HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
	}

    public ResponseEntity<String> deleteQuestionById(int questionId) {
        try{
			questionDao.deleteById(questionId) ;
			return new ResponseEntity<>("Question id " + questionId + " is deleted from Database"  , HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Not able to delete", HttpStatus.BAD_REQUEST);
 
    }
}
