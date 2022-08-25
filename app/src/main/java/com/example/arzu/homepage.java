package com.example.arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Collections;

public class homepage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "homepage";
   // TextView receiver_msg;
    String[] classes = { "First class",
           "Business", "Economy",
           "Premium Economy" };
    String[] Adultnumbers = {"1","2","3","4","5","6","7","8","9"};
    String[] childnumbers = {"0","1","2","3","4","5","6","7","8","9"};
    RadioButton round_trip,one_way;
    Spinner spin;
    Spinner adults;
    Spinner child;
    Button search,departbtn,returnbtn;
    int year,month,day,hour,minute;
    RadioGroup radioGroup;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        departbtn=(Button)findViewById(R.id.departbutton);
        returnbtn=(Button)findViewById(R.id.returnbutton);
        search=(Button)findViewById(R.id.search_flights);
        spin = (Spinner) findViewById(R.id.spinner);
        round_trip = (RadioButton) findViewById(R.id.roundtrip);
        one_way = (RadioButton) findViewById(R.id.oneway);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);

        round_trip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                returnbtn.setVisibility(View.INVISIBLE);
            }
        });
        one_way.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                returnbtn.setVisibility(View.VISIBLE);

            }
        });



        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle.setText("On");
                } else {
                    toggle.setText("off");
                }
            }
        });

        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,classes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        adults = (Spinner) findViewById(R.id.adults);
        adults.setOnItemSelectedListener(this);
        ArrayAdapter noAdults = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Adultnumbers);
        noAdults.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adults.setAdapter(noAdults);

        child = (Spinner) findViewById(R.id.childrens);
        child.setOnItemSelectedListener(this);
        ArrayAdapter noChilds = new ArrayAdapter(this,android.R.layout.simple_spinner_item, childnumbers);
        noChilds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        child.setAdapter(noChilds);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                progressDoalog = new ProgressDialog(homepage.this);
                progressDoalog.setMax(100);
                progressDoalog.setMessage("\nClass : " +
                        String.valueOf(spin.getSelectedItem()) +
                        "\nAdults : " +
                        String.valueOf(adults.getSelectedItem())+
                        "\nChildrens : " +
                        String.valueOf(child.getSelectedItem()));
                progressDoalog.setTitle("Search For Flights");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDoalog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (progressDoalog.getProgress() <= progressDoalog
                                    .getMax()) {
                                Thread.sleep(200);
                                handle.sendMessage(handle.obtainMessage());
                                if (progressDoalog.getProgress() == progressDoalog
                                        .getMax()) {
                                    progressDoalog.dismiss();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            Handler handle = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    progressDoalog.incrementProgressBy(1);
                }
            };

        });

        departbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(homepage.this, new

                        DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int

                                    dayOfMonth) {

                                departbtn.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                            }
                        },year,month,day);
                dpd.show();
            }
        });


        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(homepage.this, new

                        DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int

                                    dayOfMonth) {

                                returnbtn.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                            }
                        },year,month,day);
                dpd.show();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.arzu_menu, menu);
        return true;
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
            case R.id.feedback:
                Intent in = new Intent(this,feedback.class);
                startActivity(in);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
        return;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

   public void top(View v)
   {
       ScrollView sv= (ScrollView)findViewById(R.id.scrollViewMain);
       sv.fullScroll(ScrollView.FOCUS_UP);
   }

   public void bookflight (View v)
   {
       Intent i = new Intent(this,flightbook.class);
       startActivity(i);
       finish();
   }



}