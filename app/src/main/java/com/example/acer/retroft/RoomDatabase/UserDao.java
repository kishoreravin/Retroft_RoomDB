package com.example.acer.retroft.RoomDatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.acer.retroft.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT password from User_Table where username = :username")
    String InsertUser(String username);

    @Query("SELECT * from User_Table")
    LiveData<List<User>> getAllUsers();
}
