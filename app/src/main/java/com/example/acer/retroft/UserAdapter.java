package com.example.acer.retroft;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList = Collections.emptyList();

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_adapter,viewGroup,false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder userViewHolder, int i) {
        User user = userList.get(i);
        userViewHolder.username.setText(user.getUsername()+getItemCount());
        userViewHolder.password.setText(user.getPassword());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView username;
        private TextView password;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.user);
            password = (TextView) itemView.findViewById(R.id.pass);
        }
    }

    public void setUsers(List<User> users){
        userList = users;
        notifyDataSetChanged();
    }
}
