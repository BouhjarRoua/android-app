package com.example.testinterface;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityDetailsBinding;

import java.util.List;

public class DetailsAdminActivity extends DrawerBaseActivity {

    RecyclerView rv;
    private TextView affichertext;
    private ImageView afficherimage;
    private Button delete;
    List<Film> films;
    private AppDataBase database;
    public static  final int Read_Permission = 250;
    ActivityDetailsBinding activityDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailsBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView( activityDetailsBinding.getRoot());
        allocateActivityTitle("FilmList");

        database = AppDataBase.getAppDatabase(getApplicationContext());
      /*  affichertext=findViewById(R.id.textViewdis);
        afficherimage=findViewById(R.id.imageViewdis);*/
        delete=findViewById(R.id.delete);
        delete.setOnClickListener(v->{
            database.filmDAO().deleteAll();
            finish();
            startActivity(getIntent());
        });
        films =database.filmDAO().getAll();
        // films.add();

        if(ContextCompat.checkSelfPermission(DetailsAdminActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(DetailsAdminActivity.this,
                  new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},Read_Permission);
        }
        films =database.filmDAO().getAll();
        // films.add();
        rv=findViewById(R.id.recyclerView);
        rv.setAdapter(new MyAdapter2(films,this));
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}