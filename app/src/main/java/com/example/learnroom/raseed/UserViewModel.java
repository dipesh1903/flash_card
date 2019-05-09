package com.example.learnroom.raseed;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.learnroom.raseed.Asyncronous.User.QuestionCallback;
import com.example.learnroom.raseed.Asyncronous.User.TopicCallback;
import com.example.learnroom.raseed.Asyncronous.User.callback;
import com.example.learnroom.raseed.Entity.Questions;
import com.example.learnroom.raseed.Entity.Topics;
import com.example.learnroom.raseed.Entity.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private Repository rep;


    public UserViewModel(@NonNull Application application) {
        super(application);
        rep = new Repository(application);
    }

    public void insertUser(User user){
        rep.insertuser(user);
    }
    public void insertQuestion(Questions questions){
        rep. insertQuestion(questions);
    }

    public void getUser(callback cb){
         rep.getuser(cb);
    }

    public void insertTopic(Topics topic) {
        rep.insertTopic(topic);
    }
    public LiveData<List<Topics>> getTopic() {
        return rep.getTopic();
    }

    public void getQuestion(int id, QuestionCallback cb){
        rep.getQuestion(id,cb);
    }
}
