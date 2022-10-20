package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.testinterface.Entity.User;
import com.example.testinterface.database.AppDataBase;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstname,lastname,username,email,password;
   private Button btnregister;
   private Intent intent;
   private AppDataBase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        firstname =findViewById(R.id.textViewfirst);
        lastname =findViewById(R.id.textViewlast);
        username =findViewById(R.id.textViewUsername);
        email =findViewById(R.id.textViewEmail);
        password =findViewById(R.id.textViewPwd);

        btnregister = findViewById(R.id.buttonregister);
//add button signin
        btnregister.setOnClickListener(e-> {

            database.userDAO().insertOne(new User(firstname.getText().toString(),lastname.getText().toString()
                    ,username.getText().toString(),email.getText().toString(),password.getText().toString()));
            Toast.makeText(SignUpActivity.this, "user created", Toast.LENGTH_SHORT).show();
            intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            System.out.println(database.userDAO().getAll());


        });
    }
}