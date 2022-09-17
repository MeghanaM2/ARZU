package com.example.arzu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> userlist;
    public Adapter(List<Model>userlist){this.userlist=userlist;}
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
       int resource= userlist.get(position).getImageview1();
       String country=userlist.get(position).getTextview1();
       String date = userlist.get(position).getTextview2();
        String dtime = userlist.get(position).getTextview3();
        String atime = userlist.get(position).getTextview4();
        String price = userlist.get(position).getTextview5();
       holder.setData(resource,country,date,dtime,atime,price);
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview1;
        private TextView textview1;
        private TextView textview2;
        private TextView textview3;
        private TextView textview4;
        private TextView textview5;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageview1=itemView.findViewById(R.id.imageview1);
            textview1=itemView.findViewById(R.id.textview1);
            textview2=itemView.findViewById(R.id.textview2);
            textview3=itemView.findViewById(R.id.textview3);
            textview4=itemView.findViewById(R.id.textview4);
            textview5=itemView.findViewById(R.id.textview5);
        }

        public void setData(int resource, String country, String date, String dtime, String atime, String price) {
            imageview1.setImageResource(resource);
            textview1.setText(country);
            textview2.setText(date);
            textview3.setText(dtime);
            textview4.setText(atime);
            textview5.setText(price);
        }
    }
}
