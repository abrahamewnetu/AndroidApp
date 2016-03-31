package com.example.abrahamewnetu.QuizApp;

/**
 * Created by Rajan Alex on 1/25/2016.
 */

public class Question {
    private String question_string;
    boolean answer;
    public Question(String s, boolean b){
        question_string = s;
        answer = b;
    }
    public String get_question(){
        return question_string;
    }
    public boolean get_answer(){
        return answer;
    }
}
