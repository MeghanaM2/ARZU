package com.example.arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        WebView w = (WebView) findViewById(R.id.web);
        w.loadUrl("https://www.holidify.com/collections/best-places-in-the-world");
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());
        Button submit = (Button)findViewById(R.id.submit_feedback);
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        // Create a snackbar
                        Snackbar snackbar
                                = Snackbar
                                .make(
                                        v,
                                        "Feedback Submitted",
                                        Snackbar.LENGTH_LONG)
                                .setAction(
                                        "UNDO",
                                        new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view)
                                            {
                                                Toast
                                                        .makeText(
                                                                feedback.this,
                                                                "Undo Clicked",
                                                                Toast.LENGTH_SHORT)
                                                        .show();
                                            }
                                        });

                        snackbar.show();
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