package com.example.quizApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizWrraper {

    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
