package com.example.test.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    TextView username, password1;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = (TextView) findViewById(R.id.textView4);
        password1 = (TextView) findViewById(R.id.textView7);
    }

    public void load(View view) {
        try {
            FileInputStream fis = openFileInput("mil.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read =fis.read())!=-1){
                buffer.append((char)read);
            }
            String name = buffer.substring(0,buffer.indexOf(" "));
            String pass = buffer.substring((buffer.indexOf(" ")+1));
            username.setText(name);
            password1.setText(pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void previous(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
