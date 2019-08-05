package com.example.acer.retroft;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


import com.google.gson.annotations.Expose;
@Entity(tableName = "User_Table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    @Expose(serialize = true,deserialize = true)
    private String username;
    @NonNull
    @ColumnInfo(name = "password")
    @Expose(serialize = true,deserialize = true)
    private String password;


    public User(@NonNull String username,@NonNull String password){
        this.username = username;
        this.password = password;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @NonNull
    public String getUsername() {
        return username;
    }
}
