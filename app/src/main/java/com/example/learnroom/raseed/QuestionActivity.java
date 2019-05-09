package com.example.learnroom.raseed;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.learnroom.raseed.Entity.Questions;

public class QuestionActivity extends AppCompatActivity {

    private UserViewModel model;
    private int name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        model = ViewModelProviders.of(this).get(UserViewModel.class);
        name = getIntent().getExtras().getInt("topic_id");
        Log.e("d,hvbdkfvdfv df",name+"");

    }

    public void addQuestion(View view) {

        EditText q = findViewById(R.id.question);
        EditText a = findViewById(R.id.answer);
        model.insertQuestion(new Questions(q.getText().toString(),a.getText().toString(),name));
        finish();
    }
}
