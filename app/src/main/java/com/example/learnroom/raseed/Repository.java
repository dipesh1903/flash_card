package com.example.learnroom.raseed;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.learnroom.raseed.Asyncronous.User.QuestionCallback;
import com.example.learnroom.raseed.Asyncronous.User.UserGetAsync;
import com.example.learnroom.raseed.Asyncronous.User.callback;
import com.example.learnroom.raseed.Dao.QuestionsDao;
import com.example.learnroom.raseed.Dao.QuizzDao;
import com.example.learnroom.raseed.Dao.TopicsDao;
import com.example.learnroom.raseed.Dao.UserDao;
import com.example.learnroom.raseed.Entity.Questions;
import com.example.learnroom.raseed.Entity.Topics;
import com.example.learnroom.raseed.Entity.User;

import java.util.List;

public class Repository {

    private QuestionsDao questionsDao;
    private QuizzDao quizzDao;
    private UserDao userDao;
    private TopicsDao topicsDao;
    private LiveData<List<Topics>> topics;

    Repository(Application application) {
        roomDatabase db = roomDatabase.getDatabase(application);

        questionsDao = db.getQuestionsDao();
        quizzDao = db.getQuizzDao();
        userDao = db.getUserDao();
        topicsDao = db.getTopicsDao();
        topics = topicsDao.getTopics();

    }

    public void getuser(callback cb){
        final User[] u = new User[1];
        new UserGetAsync(userDao, cb).execute();

    }
    public void insertuser(User user){
        new addAsync(userDao).execute(user);
    }

    public void insertTopic(Topics topic) {
        new addTopicsAsync(topicsDao).execute(topic);
    }

    public LiveData<List<Topics>> getTopic() {
        return topics;
    }
    public void insertQuestion(Questions question){
        new addQuestionAsync(questionsDao).execute(question);
    }

    public void getQuestion(int id, QuestionCallback cb){
        new QuestionAsync(cb,id,questionsDao).execute();

    }

    private static class QuestionAsync extends AsyncTask<Void, Void, List<Questions>> {

        private QuestionCallback cb;
        private int id;
        private QuestionsDao dao;

        public QuestionAsync(QuestionCallback cb, int id, QuestionsDao dao){
            this.dao = dao;
            this.id = id;
            this.cb = cb;
        }


        @Override
        protected List<Questions> doInBackground(Void... voids) {
            return dao.getQuestions(id);
        }

        @Override
        protected  void onPostExecute(List<Questions> questions) {
            cb.getQuestion(questions);
        }
    }

    private static class addAsync extends AsyncTask<User, Void, Void>{
        private UserDao dao;

        addAsync(UserDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... users) {
            dao.insert(users[0]);
            Log.e("fkunbfd","dfljuhdkugjundkfjgknjdfnbkjdfnbjfdnbdfbdbdfb");
            return null;

        }


    }



    private static class addTopicsAsync extends AsyncTask<Topics, Void, Void> {

        private TopicsDao dao;
        addTopicsAsync(TopicsDao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Topics... topics) {
            dao.insert(topics[0]);
            return null;
        }

    }

    private static class addQuestionAsync extends AsyncTask<Questions, Void, Void>{
        private QuestionsDao dao;

        addQuestionAsync(QuestionsDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Questions... question) {
            dao.insert(question[0]);
            Log.e("fkunbfd","dfljuhdkugjundkfjgknjdfnbkjdfnbjfdnbdfbdbdfb");
            return null;

        }


    }


}
