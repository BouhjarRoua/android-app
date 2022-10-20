package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityAddFilmBinding;

public class AddFilmActivity extends DrawerBaseActivity {
     private EditText name,poster,cinema,description;
    private Button btnadd;
    private Intent intent;
    private AppDataBase database;
    ActivityAddFilmBinding activityAddFilmBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String username = getIntent().getStringExtra("username");
        activityAddFilmBinding= ActivityAddFilmBinding.inflate(getLayoutInflater());
        setContentView(activityAddFilmBinding.getRoot());
        allocateActivityTitle("AddCinema");

        database = AppDataBase.getAppDatabase(getApplicationContext());
        name =findViewById(R.id.textViewNameFilm);
        poster = findViewById(R.id.InputPoster);
        cinema = findViewById(R.id.cinemafield);
        description = findViewById(R.id.descriptionfield);
        btnadd=findViewById(R.id.buttonaddfilm);


        btnadd.setOnClickListener(e->{
            database.filmDAO().insertOne(new Film(name.getText().toString(),poster.getText().toString(),
                    cinema.getText().toString(),description.getText().toString()));
            Toast.makeText(AddFilmActivity.this, "Film Successfully added!", Toast.LENGTH_SHORT).show();
            intent = new Intent(AddFilmActivity.this, ProfileActivity.class);
            startActivity(intent);
            System.out.println(database.filmDAO().getAll());
        });

    }
}