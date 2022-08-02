package com.example.arzu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginbtn;
    EditText mailid;
    String username;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mailid =(EditText) findViewById(R.id.user);
        Toast.makeText(this, "the text is - "+mailid, Toast.LENGTH_SHORT).show();
        username = mailid.getText().toString();


        Toast.makeText(this, "onCreate MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate MainActivity");

        loginbtn =(Button) findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg("Loading...");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart MainActivity");


    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume MainActivity");

    }
    @Override
    protected void onPause() {

        Toast.makeText(this, "onPause MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause MainActivity");

        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop MainActivity");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart MainActivity");


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy MainActivity");


    }




    public void toastMsg(String msg) {

        Intent i = new Intent(this,homepage.class);
        //i.putExtra("message_key", username);
        startActivity(i);
        finish();
    }

}