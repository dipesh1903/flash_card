package com.example.learnroom.raseed.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.learnroom.raseed.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    Long insert(User user);


    @Query("Select * from User ")
    User getUser();

}
