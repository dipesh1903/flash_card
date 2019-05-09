package com.example.learnroom.raseed.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Questions",foreignKeys = @ForeignKey(entity = Topics.class,
parentColumns = "topic_id",
        childColumns = "topic_rel_id",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
))
public class Questions {

    @PrimaryKey(autoGenerate = true)
    public int question_id;

    @NonNull
    public String question_name;

    @NonNull
    public String question_answer;


    public int topic_rel_id;

    public Questions(String question_name, String question_answer, int topic_rel_id){
        this.question_answer = question_answer;
        this.question_name = question_name;
        this.topic_rel_id = topic_rel_id;
    }
}
