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

        username = mailid.getText().toString();




        loginbtn =(Button) findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMsg("Loading...");
            }
        });
    }




    public void toastMsg(String msg) {

        Intent i = new Intent(this,homepage.class);
        //i.putExtra("message_key", username);
        startActivity(i);
        finish();
    }

}