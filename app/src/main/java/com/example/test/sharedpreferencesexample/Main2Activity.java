package com.example.test.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView username , password1;
    public static final String DEFAULT = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = (TextView) findViewById(R.id.textView4);
        password1 = (TextView) findViewById(R.id.textView7);
    }

    public void load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_APPEND);
        String name = sharedPreferences.getString("name",DEFAULT);
        String password = sharedPreferences.getString("password",DEFAULT);



        if(name.equals(DEFAULT)||password.equals(DEFAULT)){
            Toast.makeText(this,"NO data found ",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"Data Loaded successfully",Toast.LENGTH_SHORT).show();
            username.setText(name);
            password1.setText(password);
        }

    }

    public void previous(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
