package com.example.arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class homepage extends AppCompatActivity {
    private static final String TAG = "homepage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        Toast.makeText(this, "onCreate MainActivity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate MainActivity");
        setContentView(R.layout.activity_homepage);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.arzu_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart HomeScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart HomeScreen");


    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume HomeScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume HomeScreen");

    }
    @Override
    protected void onPause() {

        Toast.makeText(this, "onPause HomeScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause HomeScreen");

        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop HomeScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop HomeScreen");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart HomeScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart HomeScreen");


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy HomeScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy HomeScreen");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about_us:
                Intent i = new Intent(this,Aboutus.class);
                startActivity(i);
                finish();
//                newGame();
                return true;
            case R.id.contact_us:
                Uri uri = Uri.parse("tel:8005551234");
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}