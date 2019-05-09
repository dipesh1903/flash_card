package com.example.learnroom.raseed;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnroom.raseed.Asyncronous.User.QuestionCallback;
import com.example.learnroom.raseed.Entity.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizzActivity extends AppCompatActivity {

    private UserViewModel model;
    private List<Questions> words;
    private List<Questions> questions;
    private int id;
    private  String defn;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        id = getIntent().getExtras().getInt("topic_id");
        Log.e("nnnnnnnn",id+"");
        model = ViewModelProviders.of(this).get(UserViewModel.class);
        model.getQuestion(id, new QuestionCallback() {
            @Override
            public void getQuestion(List<Questions> question) {
                Log.e("dhnsdkjvndkjsnv", question.get(0).question_name+"");
                    setValue(question);

            }
        });



    }

    private void setValue(List<Questions> question) {
        questions = question;
        Log.e("yndvjd",questions+"");
        chooseWord();
    }

    private void chooseWord() {
        if(questions.isEmpty()){
            Toast.makeText(getApplicationContext(),"no questions",Toast.LENGTH_SHORT).show();
        }
        Random ran = new Random();
        int index = ran.nextInt(questions.size());
        String word = questions.get(index).question_name;
        defn = questions.get(index).question_answer;

        List<String> options = new ArrayList<String>();
        for(int i=0;i<questions.size();i++){
            options.add(questions.get(i).question_answer);
        }
        if(options.size() > 1) {
            options.remove(defn);
        }
        Collections.shuffle(options);
        if(options.size() > 5) {
            options = options.subList(0, 3);
        }
        options.add(defn);
        Collections.shuffle(options);
        TextView tv = (TextView)findViewById(R.id.quiz_question);
        tv.setText(word);
        RadioButton r1 = findViewById(R.id.a);
        RadioButton r2 = findViewById(R.id.b);
        RadioButton r3 = findViewById(R.id.c);
        RadioButton r4 = findViewById(R.id.d);
        r1.setText(options.get(0));
        r2.setText(options.get(1));
        r3.setText(options.get(2));
        r4.setText(options.get(3));

    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.a:
                if (checked)
                    // Pirates are the best
                {
                    RadioButton r = findViewById(R.id.a);
                    if(r.getText().toString() == defn) {
                        points++;
                    }
                        else{
                            points--;
                        }
                }
            case R.id.b:
                if (checked)
                    // Ninjas rule
                {
                    RadioButton r = findViewById(R.id.b);
                    if(r.getText().toString() == defn) {
                        points++;
                    }
                    else{
                        points--;
                    }
                }

            case R.id.c:
                if (checked)
                // Ninjas rule
                {
                    RadioButton r = findViewById(R.id.c);
                    if(r.getText().toString() == defn) {
                        points++;
                    }
                    else{
                        points--;
                    }
                }

            case R.id.d:
                if (checked)
                // Ninjas rule
                {
                    RadioButton r = findViewById(R.id.d);
                    if(r.getText().toString() == defn) {
                        points++;
                    }
                    else{
                        points--;
                    }
                }

        }

        TextView tv = findViewById(R.id.score);
        tv.setText("score"+ points);
        chooseWord();

    }
}
