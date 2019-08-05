package com.example.acer.retroft.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.acer.retroft.User;

import java.util.List;

public class UserRepo {
    public UserDao mUserDao;
    private LiveData<List<User>> userList;

    UserRepo(Application application){
        UserDatabase userDatabase = UserDatabase.getDatabase(application);
        mUserDao = userDatabase.userDao();
        userList = mUserDao.getAllUsers();
    }

    LiveData<List<User>> getUserList(){
        return userList;
    }

    public void InserUser(User user){
        new insertAsyncTask(mUserDao).execute(user);
    }

    static class insertAsyncTask extends AsyncTask<User,Void,Void>{


        private UserDao mUserDao;

        insertAsyncTask(UserDao mUserDao) {
            this.mUserDao=mUserDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.insert(users[0]);
            return null;
        }
    }
}
