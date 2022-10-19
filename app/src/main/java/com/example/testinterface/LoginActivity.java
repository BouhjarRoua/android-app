package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testinterface.database.AppDataBase;

public class LoginActivity extends AppCompatActivity {
     private Button btnsignup;
     private Intent intent;
   private  Button btnsignin;
    private AppDataBase database;
   private EditText email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        email =findViewById(R.id.email);
        password=findViewById(R.id.password);
        btnsignup =findViewById(R.id.signup);
        btnsignin =findViewById(R.id.login);
        database = AppDataBase.getAppDatabase(getApplicationContext());

        btnsignup.setOnClickListener(e-> {
            intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);


        });
        btnsignin.setOnClickListener(e-> {
            String emailcheck = email.getText().toString();
            String pwdcheck = password.getText().toString();

            if(database.userDAO().login(emailcheck,pwdcheck)) {
                Toast.makeText(LoginActivity.this, "user logged", Toast.LENGTH_SHORT).show();
                intent = new Intent(LoginActivity.this, CinemaActivity.class);
                startActivity(intent);
                System.out.println(database.userDAO().getAll());

            }else{
                Toast.makeText(LoginActivity.this, "email or password invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}