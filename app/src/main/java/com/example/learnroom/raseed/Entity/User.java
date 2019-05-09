package com.example.learnroom.raseed.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "User")
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int user_id;

    @ColumnInfo(name = "user_name")
    public String user_name;

    public int user_age;

    public User(String user_name, int user_age){
        this.user_name = user_name;
        this.user_age = user_age;
    }
}
