package com.example.acer.retroft;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.acer.retroft.RoomDatabase.UserDatabase;
import com.example.acer.retroft.RoomDatabase.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewUsers extends AppCompatActivity {

    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        UserDatabase db = UserDatabase.getDatabase(getApplicationContext());
        final UserAdapter userAdapter = new UserAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setAdapter(userAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userViewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userAdapter.setUsers(users);
            }
        });
    }
}
