package com.example.learnroom.raseed.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Topics")
public class Topics {

    @PrimaryKey(autoGenerate = true)
    public int topic_id;

    public String topic_name;

    public Topics(String topic_name) {

        this.topic_name = topic_name;

    }
}
