package com.example.testinterface;

import static com.example.testinterface.databinding.ActivityCinemaBinding.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.widget.TextView;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityCinemaBinding;


import java.util.List;
import java.util.Objects;

public class CinemaActivity extends DrawerBaseActivity {
    ActivityCinemaBinding activityCinemaBinding ;//= bind(getLayoutInflater().inflate(R.layout.activity_cinema,));
    String[] items= {"Pathe","ABC","lecolisée"};
    TextView session;

    RecyclerView rv;
    List<Film> films;
    private AppDataBase database;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
   // ActivityDrawerBaseBinding activityDrawerBaseBinding;
   private SharedPreferences mPreferences;
    public static final String sharedPrefFile = "MyAuth";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityCinemaBinding =activityCinemaBinding.inflate(getLayoutInflater());
        //activityCinemaBinding = bind(getLayoutInflater().inflate(R.layout.activity_cinema,));

        setContentView(activityCinemaBinding.getRoot());
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        allocateActivityTitle("Cinema");
        database = AppDataBase.getAppDatabase(getApplicationContext());

        session = findViewById(R.id.textView);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        if(mPreferences.contains("email")){

            session.setText(mPreferences.getString("email",""));


        }
        //session.setText( mPreferences.getString("email","") );
       autoCompleteTextView= findViewById(R.id.auto_complete_text);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            String item =parent.getItemAtPosition(position).toString();

        });
        /*if(username.equals("admin@gmail.com")){
            admin.setText("drrrrr");
        }*/
        films =database.filmDAO().getAll();
        // films.add();
        rv=findViewById(R.id.recyclerView2);
        rv.setAdapter(new MyAdapter(films,this));
        rv.setLayoutManager(new LinearLayoutManager(this));


    }
}