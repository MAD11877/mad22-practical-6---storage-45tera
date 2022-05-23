package com.example.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        Button gp1 =findViewById(R.id.gp1);
        Button gp2 =findViewById(R.id.gp2);

        gp1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft1 = fm.beginTransaction();
                ft1.replace(R.id.framelay,Group1.class,null)
                        .commit();
            }
        });


        gp2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft1 = fm.beginTransaction();
                ft1.replace(R.id.framelay,Group2.class,null)
                    .commit();
            }
        });

    }

}