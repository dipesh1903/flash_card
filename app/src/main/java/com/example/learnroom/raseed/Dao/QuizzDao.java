package com.example.learnroom.raseed.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.learnroom.raseed.Entity.Quizz;

import java.util.List;

@Dao
public interface QuizzDao {

    @Insert
    void insert(Quizz quizz);

    @Query("Select * from Quizz")
    Quizz getResult();

    @Query("Select * from Quizz where topic_rel_id =  :id")
    Quizz getTopicResult(int id);

}
