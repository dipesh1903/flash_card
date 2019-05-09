package com.example.learnroom.raseed;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.learnroom.raseed.Entity.Topics;

public class AddTopicActivity extends AppCompatActivity {

    private UserViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_topic);
        model = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    public void addTopic(View view) {
        EditText tv = findViewById(R.id.topic);

        model.insertTopic(new Topics(tv.getText().toString()));
        finish();

    }
}
