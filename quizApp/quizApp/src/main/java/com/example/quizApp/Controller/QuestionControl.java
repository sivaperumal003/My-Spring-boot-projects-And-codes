package com.example.quizApp.Controller;

import com.example.quizApp.Model.Questions;
import com.example.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionControl {

    @Autowired
    QuestionService service;

    @GetMapping("/allquestions")
    public List<Questions> allQuestion(){
        return service.allQuestion();

    }

    @GetMapping("category/{category}")
    public List<Questions> getByCategory(@PathVariable("category") String category){
        return service.getByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Questions question){
        return service.addQuestion(question);

    }

}
