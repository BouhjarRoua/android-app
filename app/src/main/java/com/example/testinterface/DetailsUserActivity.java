package com.example.testinterface;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testinterface.database.AppDataBase;


public class DetailsUserActivity extends DrawerBaseActivity{

    TextView nom,cinema,id;
    ImageView picture;
    EditText description;
    Button book;
    DetailsUserActivity detailsUserActivity;
    private AppDataBase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // detailsUserActivity =detailsUserActivity.inflate();
        setContentView(R.layout.activity_userdetails);
        //setTitle(getIntent().getStringExtra("name")+"detail");
        database = AppDataBase.getAppDatabase(getApplicationContext());
        nom = findViewById(R.id.name);
        cinema = findViewById(R.id.cinema);
        picture = findViewById(R.id.poster);
        description = findViewById(R.id.Description);
        book=findViewById(R.id.button);
            id=findViewById(R.id.idtest);
            nom.setText(getIntent().getStringExtra("name"));
            cinema.setText(getIntent().getStringExtra("cinema"));
            description.setText(getIntent().getStringExtra("description"));
            picture.setImageURI(Uri.parse(getIntent().getStringExtra("picture")));
            //id.setText(getIntent().getStringExtra("id"));
          /*  book.setOnClickListener(e->{
          for(
                database.filmDAO().reserve(id.setText(getIntent().getStringExtra("id")));
            });*/

    }
}