package com.example.learnroom.raseed.Asyncronous.User;

import com.example.learnroom.raseed.Entity.Questions;

import java.util.List;

public interface QuestionCallback {

    public void getQuestion(List<Questions> question);
}
