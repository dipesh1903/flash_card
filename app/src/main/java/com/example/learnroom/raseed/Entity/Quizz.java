package com.example.learnroom.raseed.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Quizz",foreignKeys = @ForeignKey(entity = Topics.class,
        parentColumns = "topic_id",
        childColumns = "topic_rel_id",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
))
public class Quizz {

    @PrimaryKey(autoGenerate = true)
    public int quizz_id;

    @NonNull
    public int quizz_wrong_answer;

    @NonNull
    public int quizz_right_answer;

    @NonNull
    public int topic_rel_id;

    public Quizz(int quizz_right_answer, int quizz_wrong_answer, int topic_rel_id){
        this.quizz_right_answer = quizz_right_answer;
        this.quizz_wrong_answer = quizz_wrong_answer;
        this.topic_rel_id = topic_rel_id;
    }

}
