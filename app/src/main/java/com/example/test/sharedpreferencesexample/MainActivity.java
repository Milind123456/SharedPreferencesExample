package com.example.test.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

    }

    public void next(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }

    public void save(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_APPEND);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();


    }
}
