package com.example.learnroom.raseed;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.learnroom.raseed.Dao.QuestionsDao;
import com.example.learnroom.raseed.Dao.QuizzDao;
import com.example.learnroom.raseed.Dao.TopicsDao;
import com.example.learnroom.raseed.Dao.UserDao;
import com.example.learnroom.raseed.Entity.Questions;
import com.example.learnroom.raseed.Entity.Quizz;
import com.example.learnroom.raseed.Entity.Topics;
import com.example.learnroom.raseed.Entity.User;

@Database(entities = {Quizz.class,Questions.class,Topics.class,User.class}, version = 1, exportSchema = false)
public abstract class roomDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();
    public abstract QuizzDao getQuizzDao();
    public abstract TopicsDao getTopicsDao();
    public abstract QuestionsDao getQuestionsDao();

    public static roomDatabase instance;

    public static roomDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (roomDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            roomDatabase.class, "room_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

}
