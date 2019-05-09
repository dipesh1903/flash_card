package com.example.learnroom.raseed.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.example.learnroom.raseed.Entity.Questions;

import java.util.List;

@Dao
public interface QuestionsDao {

    @Insert
    void insert(Questions questions);


    @Query("select * from Questions where topic_rel_id = :id")
    List<Questions> getQuestions(int id);

}
