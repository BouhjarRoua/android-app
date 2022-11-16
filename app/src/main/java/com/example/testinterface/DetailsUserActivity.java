package com.example.testinterface;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.Entity.User;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityDetailsBinding;
import com.example.testinterface.databinding.ActivityUserdetailsBinding;

import java.util.List;


public class DetailsUserActivity extends DrawerBaseActivity{

    TextView nom,cinema,id;
    ImageView picture;
    TextView description;
    Button book;
    List<Film> films;
    Film ff;
   ActivityUserdetailsBinding activityUserdetailsBinding;
    private AppDataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserdetailsBinding=ActivityUserdetailsBinding.inflate(getLayoutInflater());
        setContentView(activityUserdetailsBinding.getRoot());
        //setTitle(getIntent().getStringExtra("name")+"detail");
        database = AppDataBase.getAppDatabase(getApplicationContext());
        nom = findViewById(R.id.name);
        cinema = findViewById(R.id.cinema);
        picture = findViewById(R.id.poster);
        description=findViewById(R.id.Description);
        //description = findViewById(R.id.Description);
        book=findViewById(R.id.button);
            id=findViewById(R.id.idtest);
            nom.setText(getIntent().getStringExtra("name"));
            cinema.setText(getIntent().getStringExtra("cinema"));
            description.setText(getIntent().getStringExtra("description"));
            picture.setImageURI(Uri.parse(getIntent().getStringExtra("picture")));
            int str=getIntent().getIntExtra("id",0);
            id.setText(""+str);
            System.out.println(str);
            films=database.filmDAO().getAll();
            book.setOnClickListener(v->{
            for(int i=0;i<films.size();i++){
                if(database.filmDAO().getId(i)==str){
                    int participant=database.filmDAO().getParticipant();
                    database.filmDAO().reserve(str,participant+1);
                   Film test=database.filmDAO().findById(str);
                    System.out.println(test);

                }

            }
               Intent intent = new Intent(DetailsUserActivity.this, CinemaActivity.class);
                startActivity(intent);
            });


            //id.setText(Integer.parseInt(getIntent().getStringExtra("id")));
          /*  book.setOnClickListener(e->{
          for(
                database.filmDAO().reserve(id.setText(getIntent().getStringExtra("id")));
            });*/

    }
}