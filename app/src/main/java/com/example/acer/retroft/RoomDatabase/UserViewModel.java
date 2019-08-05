package com.example.acer.retroft.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.acer.retroft.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepo userRepo;
    private LiveData<List<User>> userList;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo = new UserRepo(application);
        userList = userRepo.getUserList();
    }

    public LiveData<List<User>> getUserList(){
        return userList;
    }

    public void InsertUser(User user){
        userRepo.InserUser(user);
    }
}
