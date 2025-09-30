package com.example.quizApp.Service;

import com.example.quizApp.Model.QuizWrraper;
import com.example.quizApp.Model.Questions;
import com.example.quizApp.Model.Quiz;
import com.example.quizApp.Repository.QuestionRepo;
import com.example.quizApp.Repository.QuizRepo;
import com.example.quizApp.Respose;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo Qrepo;

    @Autowired
    QuestionRepo Questionrepo;



    public String addQuiz(String category, int num, String title) {

        List<Questions> questions=Questionrepo.findRandomQuestionsByCategory(category, num);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        Qrepo.save(quiz);

        return "Success";
    }

    public List<QuizWrraper> getAlQuiz(int id) {
       Optional<Quiz> quiz=Qrepo.findById(id);

       List<Questions> quesList=quiz.get().getQuestions();
       List<QuizWrraper> Quizshow=new ArrayList<>();
       for(Questions q:quesList){
           QuizWrraper wrraper=new QuizWrraper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());

           Quizshow.add(wrraper);


       }
       return Quizshow;
    }

    public int getResponse(int id, List<Respose> res) {
     Quiz quiz=Qrepo.findById(id).get();
     List<Questions> questions=quiz.getQuestions();
     int right=0;
     int i=0;
     for(Respose r:res){
         if(r.getRespose().equals(questions.get(i).getRightAnswer())){
             right++;

         }
         i++;

     }
     return right;
    }
}
