package com.example.acer.retroft;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.retroft.Retrofit.UserInterface;
import com.example.acer.retroft.RoomDatabase.UserDatabase;
import com.example.acer.retroft.RoomDatabase.UserRepo;
import com.example.acer.retroft.RoomDatabase.UserViewModel;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddUser extends AppCompatActivity {

    private EditText userNameEdit;
    private EditText passwordEdit;
    private UserDatabase db;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        userNameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
        Button addUser = findViewById(R.id.adduser);
        final UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

//        db = UserDatabase.getDatabase(getApplicationContext());
//
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        final Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://c118879e.ngrok.io")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build();

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final User user = new User(userNameEdit.getText().toString(),passwordEdit.getText().toString());
//                UserInterface userInterface = retrofit.create(UserInterface.class);
//                Call<List<User>> call = userInterface.addNewUser(user);
//                call.enqueue(new Callback<List<User>>() {
//                    @Override
//                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                        Toast.makeText(getBaseContext(),"added",Toast.LENGTH_SHORT).show();
//                        db.userDao().insert(user);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<User>> call, Throwable t) {
//                        Toast.makeText(getBaseContext(),t.toString(),Toast.LENGTH_SHORT).show();
//                    }
//                });

                User user = new User(userNameEdit.getText().toString(),passwordEdit.getText().toString());
                userViewModel.InsertUser(user);
            }
        });
    }
}
