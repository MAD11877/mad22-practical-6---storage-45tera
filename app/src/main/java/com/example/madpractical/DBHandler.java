package com.example.madpractical;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c){
        super(c,"User.db",null,1);
        //version number will be tagged with the database (if new)
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql =
        "CREATE TABLE User(name TEXT,description TEXT,id INT,followed BOOL)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }
    public void insertUser(User use){
        SQLiteDatabase db = this.getWritableDatabase();
        //reminder to add the escape ""
        db.execSQL("INSERT INTO User VALUES(\"" +use.name + "\",\"" + use.description + "\",\"" + use.id + "\",\"" +  use.followed + "\")");

            //INSERT INTO User VALUES("name","description","int","followed")
    }

    //using cursor
    public ArrayList getUser(){
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<User> userList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM User",null);

        while(cursor.moveToNext()){
            User u = new User();
            u.name = cursor.getString(0); // 0 is the column number
            u.description = cursor.getString(1);
            u.id = cursor.getInt(2);
            u.followed = cursor.getWantsAllOnMoveCalls();
            userList.add(u);
        }
        return userList;
    }

    //update value in database - "UPDATE userdata SET Name=\"" + newUser.mnme"\"" + "
    public void updateUser(User usr){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User WHERE id = ? " ,new String[]{"" + usr.id});

        Boolean result =cursor.moveToNext();
        if (result){
            Integer eyed = cursor.getInt(2); //id from Database

            if(eyed == usr.id) {
                Boolean follow = cursor.getWantsAllOnMoveCalls(); //follow from Database

                if (usr.followed == true){
                    follow = false;//in the case where followed = true
                    usr.followed = false;
                }
                if (!usr.followed) {
                 follow =true;
                 usr.followed = true;

                }
          ;
            }

        }

    }

}
