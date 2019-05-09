package com.example.learnroom.raseed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TopicInfoActivity extends AppCompatActivity {

    private int name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_info);
        name = getIntent().getExtras().getInt("topic");
        Toast.makeText(getApplicationContext(),name+"",Toast.LENGTH_SHORT).show();
        TextView tv = findViewById(R.id.selected_topic);
        tv.setText(name+"");
    }

    public void addQuestion(View view) {

        Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
        intent.putExtra("topic_id",name);
        startActivity(intent);

    }

    public void startPractice(View view) {
        Intent in = new Intent(getApplicationContext(),QuizzActivity.class);
        in.putExtra("topic_id",name);
        startActivity(in);

    }
}
