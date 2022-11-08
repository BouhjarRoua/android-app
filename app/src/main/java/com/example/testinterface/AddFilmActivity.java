package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testinterface.Entity.Film;
import com.example.testinterface.database.AppDataBase;
import com.example.testinterface.databinding.ActivityAddFilmBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.stream.Stream;

public class AddFilmActivity extends DrawerBaseActivity {
     private EditText name,description;
    private Button btnadd,select;
    private ImageView poster;
    String[] items= {"Pathe","ABC","lecolisée"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

     Intent ACTION_VIEW;
    private AppDataBase database;
    int SELECT_PICTURE = 200;
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
        select = findViewById(R.id.select);
        poster=findViewById(R.id.poster);

        description = findViewById(R.id.descriptionfield);
        btnadd=findViewById(R.id.buttonaddfilm);
        autoCompleteTextView= findViewById(R.id.auto_complete_text);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            String item =parent.getItemAtPosition(position).toString();


        });
        select.setOnClickListener(v->{

            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_OPEN_DOCUMENT);

            // pass the constant to compare it
            // with the returned requestCode
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
        });

       /* btnadd.setOnClickListener(e->{

            database.filmDAO().insertOne(new Film(name.getText().toString(),selectedImageUri.toString(),
                    cinema.getText().toString(),description.getText().toString()));
            Toast.makeText(AddFilmActivity.this, "Film Successfully added!", Toast.LENGTH_SHORT).show();
            intent = new Intent(AddFilmActivity.this, ProfileActivity.class);
            startActivity(intent);
            System.out.println(database.filmDAO().getAll());
        });*/
        btnadd.setOnClickListener(n-> {

           onActivityResult(SELECT_PICTURE,RESULT_OK, ACTION_VIEW ) ;






        });

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                System.out.println(selectedImageUri);
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                   poster.setImageURI(selectedImageUri);


                    InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImageUri);
                        Bitmap finalPicture = BitmapFactory.decodeStream(imageStream);
                        System.out.println(finalPicture);
                        poster.setImageBitmap(finalPicture);
                        database.filmDAO().insertOne(new Film(name.getText().toString(),poster.toString(),
                               autoCompleteTextView.getText().toString(),description.getText().toString()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bitmap finalPicture = BitmapFactory.decodeStream(imageStream);
                    System.out.println(finalPicture);
                    poster.setImageBitmap(finalPicture);
                }

            }
        }

        Intent intent = new Intent(AddFilmActivity.this, DetailsActivity.class);
        startActivity(intent);
        Toast.makeText(AddFilmActivity.this, "Film Successfully added!", Toast.LENGTH_SHORT).show();
        System.out.println(database.filmDAO().getAll());

    }
}