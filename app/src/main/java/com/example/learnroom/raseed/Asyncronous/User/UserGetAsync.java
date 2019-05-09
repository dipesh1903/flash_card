package com.example.learnroom.raseed.Asyncronous.User;

import android.os.AsyncTask;
import android.util.Log;

import com.example.learnroom.raseed.Dao.UserDao;
import com.example.learnroom.raseed.Entity.User;

public  class UserGetAsync extends AsyncTask<Void,Void,User> {

    private UserDao dao;
    private callback cb;

    public UserGetAsync(UserDao dao, callback cb){
        this.cb = cb;
        this.dao = dao;
    }
    @Override
    protected User doInBackground(Void... voids) {
        User u = dao.getUser();
        Log.e("kfvndfvdfv"," edd"+u);
        return u;
    }


    @Override
    protected void onPostExecute(User user){
        cb.getUser(user);
    }
}
