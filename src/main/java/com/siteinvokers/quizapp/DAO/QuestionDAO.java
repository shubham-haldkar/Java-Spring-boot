package com.siteinvokers.quizapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siteinvokers.quizapp.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);
}
