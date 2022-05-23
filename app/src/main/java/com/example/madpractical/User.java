package com.example.madpractical;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    User(String n ,String d,int eyed,boolean f){
        this.name =n;
        this.description =d;
        this.id =eyed;
        this.followed =f;
    }

    public User() {

    }
}
