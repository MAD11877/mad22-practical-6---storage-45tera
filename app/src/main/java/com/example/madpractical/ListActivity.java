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

        //Week 6 - SQLite
        DBHandler db = new DBHandler(this);
        if (db.UserCount() == 0){
            for (int i=0;i<21;i++){
                User userA = new User();
                userA.name = "Name" + rand.nextInt(10000000);
                userA.description = "Description " + rand.nextInt(1000000000);
                userA.id = i;
                userA.followed = rand.nextBoolean();
                db.insertUser(userA);
            }
        }



        //bring in the recycler view
        RecyclerView rv = findViewById(R.id.recycle);
        ListAdapter adapter = new ListAdapter(db.getUser(),ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);


    }

}