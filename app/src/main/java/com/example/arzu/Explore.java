package com.example.arzu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Explore extends AppCompatActivity {
    ImageView fragment1,fragment2,fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        fragment1 = (ImageView) findViewById(R.id.seoul);
        fragment2 = (ImageView) findViewById(R.id.busan);
        fragment3 = (ImageView) findViewById(R.id.incheon);
        listener();
        FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
        seoul ff1=new seoul();
        f1.replace(R.id.fragment_container,ff1);
        f1.commit();

    }
    public void listener(){
        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
                seoul ff1=new seoul();
                f1.replace(R.id.fragment_container,ff1);
                f1.commit();
            }
        });
        fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
                busan ff2=new busan();
                f2.replace(R.id.fragment_container,ff2);
                f2.commit();
            }
        });
        fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
                incheon ff2=new incheon();
                f2.replace(R.id.fragment_container,ff2);
                f2.commit();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,homepage.class);
        startActivity(i);
        finish();
        return;
    }

}