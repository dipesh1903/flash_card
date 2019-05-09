package com.example.learnroom.raseed;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences sharedPref = this.getSharedPreferences("User",Context.MODE_PRIVATE);
        String name = sharedPref.getString("name", "null");
        if(name == "null") {
            Intent in = new Intent(getApplicationContext()
                    ,MainActivity.class);
            startActivity(in);
            finish();
        } else
        {
            Intent in = new Intent(getApplicationContext()
                    ,DashboardActivity.class);
            startActivity(in);
            finish();
        }

    }
}
