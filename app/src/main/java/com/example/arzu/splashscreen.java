package com.example.arzu;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashscreen extends AppCompatActivity {

    private Thread run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ImageView backgroundImage;
        backgroundImage = findViewById(R.id.imageView4);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide);
        backgroundImage.startAnimation(slideAnimation);

        Thread thread =  new Thread(){
        public void run(){
            try {
                sleep (4000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                Intent i = new Intent(splashscreen.this,MainActivity.class);
                startActivity(i);
            }
        }
        };thread.start();

    }
}