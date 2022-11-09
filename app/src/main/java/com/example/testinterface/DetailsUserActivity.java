package com.example.testinterface;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsUserActivity extends DrawerBaseActivity{

    TextView nom,cinema;
    ImageView picture;
    EditText description;
    DetailsUserActivity detailsUserActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // detailsUserActivity =detailsUserActivity.inflate();
        setContentView(R.layout.activity_userdetails);
        //setTitle(getIntent().getStringExtra("name")+"detail");
        nom = findViewById(R.id.name);
        cinema = findViewById(R.id.cinema);
        picture = findViewById(R.id.poster);
        description = findViewById(R.id.Description);

            nom.setText(getIntent().getStringExtra("name"));
            cinema.setText(getIntent().getStringExtra("cinema"));
            description.setText(getIntent().getStringExtra("description"));
            picture.setImageURI(Uri.parse(getIntent().getStringExtra("picture")));

    }
}