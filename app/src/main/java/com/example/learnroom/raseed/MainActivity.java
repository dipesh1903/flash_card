package com.example.learnroom.raseed;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnroom.raseed.Asyncronous.User.callback;
import com.example.learnroom.raseed.Entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView text;
    private UserViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        model = ViewModelProviders.of(this).get(UserViewModel.class);
    }


    public void addUser(View view) {
        EditText a = findViewById(R.id.name);
        EditText b = findViewById(R.id.age);
        SharedPreferences ref = this.getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences sharedPref = this.getSharedPreferences("User",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name",a.getText().toString());
        editor.putInt("age", Integer.parseInt(b.getText().toString()));
        editor.commit();
        model.insertUser(new User(a.getText().toString(),Integer.parseInt(b.getText().toString())));
        Intent in = new Intent(getApplicationContext(),DashboardActivity.class);
        startActivity(in);
    }

    public void getUser(View view) {
        model.getUser(new callback() {

            @Override
            public void getUser(User user) {
                User u = user;
                Log.e("mainActivity", " "+u);
                String name = u.user_name;
                int age = u.user_age;
                int id = u.user_id;
                String textt = name + " "+age+" "+id;
                TextView t = findViewById(R.id.get);
                t.setText(textt);
            }
        });

    }
}
