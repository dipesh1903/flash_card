package com.example.learnroom.raseed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnroom.raseed.Entity.Topics;

import java.util.List;

import static android.widget.Toast.*;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        rc = findViewById(R.id.recycler_topics);
        final TopicAdapter adapter = new TopicAdapter(this);
        final UserViewModel model = ViewModelProviders.of(this).get(UserViewModel.class);
        ClickListener listener = new ClickListener() {
            @Override
            public void onItemCLick(int position, View view) {
                List<Topics> ls =  model.getTopic().getValue();

                Log.e("nokia",ls.get(position).topic_id+"");
                Intent start = new Intent(getApplicationContext(), TopicInfoActivity.class);
                start.putExtra("topic",ls.get(position).topic_id);
                startActivity(start);
            }

            @Override
            public void onLongItemClick(int position, View view) {

                Toast.makeText(getApplicationContext(),position+" ",LENGTH_SHORT).show();

            }
        };
        adapter.setOnItemClickListener(listener);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new GridLayoutManager(this, 2));

        model.getTopic().observe(this, new Observer<List<Topics>>() {
            @Override
            public void onChanged(@Nullable List<Topics> topics) {
                adapter.setWords(topics);
            }
        });

    }

    public void addTopic(View view) {
        Intent in = new Intent(getApplicationContext(),AddTopicActivity.class);
        startActivity(in);
    }
}
