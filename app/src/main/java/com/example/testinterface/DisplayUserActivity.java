package com.example.testinterface;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testinterface.Entity.User;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityDisplayUserBinding;

import java.util.List;

public class DisplayUserActivity extends DrawerBaseActivity  {
    RecyclerView rv;
    private AppDataBase database;
    List<User>users;
    ActivityDisplayUserBinding activityDisplayUserBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDisplayUserBinding=ActivityDisplayUserBinding.inflate(getLayoutInflater());

        setContentView(activityDisplayUserBinding.getRoot());
        allocateActivityTitle("UserList");
        database = AppDataBase.getAppDatabase(getApplicationContext());
        users=database.userDAO().getAll();
        rv=findViewById(R.id.recyclerView);
        rv.setAdapter(new UserAdapter(users,this));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}