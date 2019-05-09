package com.example.learnroom.raseed.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.learnroom.raseed.Entity.Topics;

import java.util.List;

@Dao
public interface TopicsDao {

    @Insert
    void insert(Topics topics);

    @Query("Select * from Topics")
    LiveData<List<Topics>> getTopics();

    @Query("Select count(*) from Topics")
    int getCount();

    @Query("Select topic_id from Topics where topic_name = :name ")
    Topics getId(String name);
}
