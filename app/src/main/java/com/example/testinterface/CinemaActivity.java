package com.example.testinterface;

import static com.example.testinterface.databinding.ActivityCinemaBinding.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityCinemaBinding;


import java.util.List;
import java.util.Objects;

public class CinemaActivity extends DrawerBaseActivity {
    ActivityCinemaBinding activityCinemaBinding ;//= bind(getLayoutInflater().inflate(R.layout.activity_cinema,));
    String[] items= {"Pathe","ABC","le colisee"};
    TextView session,namefilm,cinemafilm;
    Button detailsfilm;
    Film f;
    List<Film>films2;
    String cinema;
    RecyclerView rv;
    List<Film> films;
    private AppDataBase database;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
   // ActivityDrawerBaseBinding activityDrawerBaseBinding;
   private SharedPreferences mPreferences;
    public static final String sharedPrefFile = "MyAuth";
    public static  final int Read_Permission = 250;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityCinemaBinding =activityCinemaBinding.inflate(getLayoutInflater());


        setContentView(activityCinemaBinding.getRoot());

        allocateActivityTitle("Cinema");
        database = AppDataBase.getAppDatabase(getApplicationContext());

        session = findViewById(R.id.textView);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        if(mPreferences.contains("email")){

            session.setText(mPreferences.getString("email",""));


        }

       autoCompleteTextView= findViewById(R.id.auto_complete_text2);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            String item =parent.getItemAtPosition(position).toString();
            System.out.println(item);
            cinema=item;
            cinemafilm.setText(cinema);

            films2=database.filmDAO().getByCinema(cinema);
           if(item!=null){
                rv = findViewById(R.id.recyclerView2);
                rv.setAdapter(new MyAdapter(films2, this));
                rv.setLayoutManager(new LinearLayoutManager(this));
            }
        });
        cinemafilm = findViewById(R.id.testcinema);

        System.out.println(cinema);

        if(ContextCompat.checkSelfPermission(CinemaActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(CinemaActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},Read_Permission);
        }




        System.out.println(cinema);
        films =database.filmDAO().getAll();

                rv = findViewById(R.id.recyclerView2);
                rv.setAdapter(new MyAdapter(films, this));
                rv.setLayoutManager(new LinearLayoutManager(this));





    }
}