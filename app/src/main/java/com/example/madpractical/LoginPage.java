package com.example.madpractical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ArrayList listA = new ArrayList();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://madpractical-3bac8-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference Ref = database.getReference("Users");

        findViewById(R.id.buttonLP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ref.child("mad").addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot snapshott : snapshot.getChildren()){
                            listA.add(snapshott.getValue().toString());
                        }
                       EditText user = (EditText) findViewById(R.id.editTextTextPassword);
                        EditText pass = (EditText) findViewById(R.id.editTextTextPassword2);
                        String inuser = user.getText().toString();
                        String inpass = pass.getText().toString();

                        if(inpass.equals(listA.get(0).toString()) && inuser.equals(listA.get(1).toString())){
                            Intent listact = new Intent(LoginPage.this,ListActivity.class);
                            startActivity(listact);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }





                });
            }
        });











    }
}