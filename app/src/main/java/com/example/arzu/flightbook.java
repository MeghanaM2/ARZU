package com.example.arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class flightbook extends AppCompatActivity {
    Button button;
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightbook);
        ImageView btn = (ImageView) findViewById(R.id.roundedImageView);
        registerForContextMenu(btn);

        button = (Button) findViewById(R.id.clickBtn);

        // Setting onClick behavior to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(flightbook.this, button);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        button.setText(menuItem.getTitle());
                       // Toast.makeText(flightbook.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("South Korea");
        menu.add(0, v.getId(), 0, "Share");
        menu.add(0, v.getId(), 0, "Explore");
        menu.add(0, v.getId(), 0, "Wish Tour list");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() == "Share")
        {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/");
            startActivity(Intent.createChooser(sendIntent, null));

        }
        else if (item.getTitle() == "Wish Tour list") {
            Toast.makeText(this, "Added to Wish Tour list", Toast.LENGTH_SHORT).show();

        }
        else if (item.getTitle() == "Explore") {
            Toast.makeText(this, "Explore", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this,Explore.class);
            startActivity(in);
            finish();

        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,homepage.class);
        startActivity(i);
        finish();
        return;
    }
}