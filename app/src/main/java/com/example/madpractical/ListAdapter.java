package com.example.madpractical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    ArrayList<User> userListing;
    Context c;

    public ListAdapter (ArrayList<User> userList, Context c){
        this.userListing = userList;
        this.c=c;
    }

    @Override
    public int getItemViewType(int position) {
        return (position%5==0)?0:1; //
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= null;
        item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout,null,false);
        return new ListViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        User userdata = userListing.get(position);
        holder.name.setText(userdata.name);
        holder.description.setText(userdata.description);


        //for the width
        holder.bigcircle.layout(0,0,0,0);



        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(c);
                ad.setTitle("Profile")
                        .setMessage(holder.name.getText().toString())

                        .setPositiveButton("View", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            //set the intent
                            Intent i2 = new Intent(c,MainActivity.class);
                            i2.putExtra("namae",holder.name.getText().toString());
                            i2.putExtra("desc",holder.description.getText().toString());
                            i2.putExtra("user",userdata);
                            c.startActivity(i2);
                        }
                        });
                ad.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            //it just closes
                    }
                });


                        ad.show();

            }
        });

        //check if 7
        char car7 = holder.name.getText().charAt(userdata.name.length() -1);
        char comparison = '7';
        if ( car7 == comparison){
            holder.bigcircle.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.bigcircle.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return userListing.size();
    }
}
