package com.example.arzu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class schedule_time extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Model>userlist=new ArrayList<>();

    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_time);
        initData();
        initRecylerView();
    }

    private void initData() {

        userlist.add(new Model(R.drawable.seoul,"India to Seoul","12/10/2022","Depart Time - 12:00 PM","Arrive Time - 9:00 AM","Total Price - Rs.12000"));
        userlist.add(new Model(R.drawable.incheon,"India to Incheon","22/01/2023","Depart Time - 12:00 AM","Arrive Time - 9:00 PM","Total Price - Rs.12000"));
        userlist.add(new Model(R.drawable.bangkok,"India to Bangkok","10/15/2023","Depart Time - 12:00 PM","Arrive Time - 9:00 AM","Total Price - Rs.12000"));

    }
    public void add()
    {
//        userlist = new ArrayList<>();
        userlist.add(new Model(R.drawable.busan,"India to South Korea","12/10/2022","Depart Time - 12:00 PM","Arrive Time - 9:00 AM","Total Price - Rs.12000"));

    }
    private void initRecylerView() {
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,homepage.class);
        startActivity(i);
        finish();
        return;
    }
}