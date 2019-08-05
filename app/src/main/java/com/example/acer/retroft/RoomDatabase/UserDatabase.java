package com.example.acer.retroft.RoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.acer.retroft.User;

@Database(entities = User.class,version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile UserDatabase INSTANCE;

    public static UserDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "User_Database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
