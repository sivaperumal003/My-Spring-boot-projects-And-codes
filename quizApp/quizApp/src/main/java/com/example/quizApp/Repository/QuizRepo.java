package com.example.quizApp.Repository;

import com.example.quizApp.Model.Questions;
import com.example.quizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo  extends JpaRepository<Quiz,Integer> {


}
