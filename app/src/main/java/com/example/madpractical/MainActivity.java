package com.example.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button but;
    TextView words;
    User user1 = new User();
    Boolean follow = user1.followed;
    public static final String KEY_FOLLOW = "follow_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //New user on start
        but = findViewById(R.id.follow);

        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("namae");
        String desc = receivingEnd.getStringExtra("desc");
        user1 = (User) receivingEnd.getSerializableExtra("user");


        //set description
        TextView description = findViewById(R.id.textView3);
        description.setText(desc);

        //event listener for message
        Button m = findViewById(R.id.msg);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mes = new Intent(MainActivity.this,LoginPage.class);
                startActivity(mes);
            }
        });

        //set text of the activity
        if (message !=null){
            words = findViewById(R.id.textView);
            words.setText("MAD " +message);

        }




    }
    public void onClick(View v){
        DBHandler db = new DBHandler(this);
        if(but.getText().toString().equals("Followed")){ //user wants to unfollow case
            but.setText("Follow");
            /*user1.followed =false;*/
            db.updateUser(user1); //sets the attribute to unfollowed.
            Toast.makeText(MainActivity.this,"Unfollowed!", Toast.LENGTH_SHORT).show();
        }
        else if( but.getText().toString().equals("Follow")){ //user wants to follow case
            but.setText("Followed");
            /*user1.followed =true;*/
            db.updateUser(user1); //sets the attribute to follow.
            Toast.makeText(MainActivity.this,"Followed!", Toast.LENGTH_SHORT).show();

        }

    }





}