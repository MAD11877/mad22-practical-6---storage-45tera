package com.example.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Random rand = new Random();


        //Week 4- randomising the name, description and follow status
        ArrayList<User> userList = new ArrayList<>();

        for (int i=0;i<21;i++){
            String desc = "Description " + rand.nextInt(1000000000);
            String nem = "Name" + rand.nextInt(10000000);
            userList.add(new User(nem,desc,i,rand.nextBoolean()));
        }


        //bring in the recycler view
        RecyclerView rv = findViewById(R.id.recycle);
        ListAdapter adapter = new ListAdapter(userList,ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);


    }

}