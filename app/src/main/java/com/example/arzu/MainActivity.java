package com.example.arzu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button loginbtn;
    EditText name;
    String username;
    public static final String Name = "nameKey";
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mcapref";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =(EditText) findViewById(R.id.user);

        username = name.getText().toString();

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));

        }



        loginbtn =(Button) findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg("Loading...");
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        Save();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Get();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        clear();
    }
    public void Save() {

        String n = name.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.commit();
    }
    public void clear() {
        name = (EditText) findViewById(R.id.user);

        name.setText("");


    }

    public void Get() {
        name = (EditText) findViewById(R.id.user);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }

    }

    public void toastMsg(String msg) {
        Toast.makeText(this,"hell0 - "+username ,Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,homepage.class);
        //i.putExtra("message_key", username);
        startActivity(i);
        finish();
    }

}