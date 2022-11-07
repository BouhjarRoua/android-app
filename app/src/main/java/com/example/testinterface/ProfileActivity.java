package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends DrawerBaseActivity {

    RecyclerView rv;
    List<Film>films;
    ActivityProfileBinding activityProfileBinding;
    private AppDataBase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding =activityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");
        database = AppDataBase.getAppDatabase(getApplicationContext());

        films =database.filmDAO().getAll();
       // films.add();
        rv=findViewById(R.id.recyclerView);
        rv.setAdapter(new MyAdapter(films,this));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}