package com.example.quizApp.Controller;


import com.example.quizApp.Model.QuizWrraper;
import com.example.quizApp.Respose;
import com.example.quizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService Qservice;


    @PostMapping("/add")
    public String addQuiz(@RequestParam String category,@RequestParam int num,@RequestParam String title){
        return Qservice.addQuiz(category,num,title);
    }

    @GetMapping("allQuiz/{id}")
    public List<QuizWrraper> getAllQuiz(@PathVariable("id")int id){
        return Qservice.getAlQuiz(id);

    }

    @PostMapping("Ans/{id}")
    public int quizresponse(@PathVariable int id,@RequestBody List<Respose> res){
       return  Qservice.getResponse(id,res);

    }



}
