package com.example.test.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

    }

    public void next(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    public void save(View view) throws IOException {
        String name = username.getText().toString();
        String passsword1 = password.getText().toString();
        File file = null;
        name = name + " ";
        FileOutputStream fos = openFileOutput("mil.txt",Context.MODE_APPEND);
        file = getFilesDir();
        fos.write(name.getBytes());
        fos.write(passsword1.getBytes());
        fos.close();
        Toast.makeText(this,"Saved Successfully "+file,Toast.LENGTH_SHORT).show();

    }
}
