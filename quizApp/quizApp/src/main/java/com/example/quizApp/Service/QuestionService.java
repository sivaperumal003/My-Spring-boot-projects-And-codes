package com.example.quizApp.Service;

import com.example.quizApp.Model.Questions;
import com.example.quizApp.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo Qrepo;

    public List<Questions> allQuestion() {

        return Qrepo.findAll();
    }

    public List<Questions> getByCategory(String category) {
        return Qrepo.findByCategory(category);
    }

    public String addQuestion(Questions question) {
        Qrepo.save(question);
        return "Success";
    }
}
