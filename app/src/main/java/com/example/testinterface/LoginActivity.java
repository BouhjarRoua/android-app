package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testinterface.Entity.User;
import com.example.testinterface.database.AppDataBase;

public class LoginActivity extends AppCompatActivity {
     private Button btnsignup;
     private Intent intent;
     private String session;
   private  Button btnsignin;
    private AppDataBase database;
    User user;
   private EditText email,password;
    private SharedPreferences mPreferences;
    public static final String sharedPrefFile = "MyAuth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        //email.setText( mPreferences.getString("login","") );
        email =findViewById(R.id.email);
        password=findViewById(R.id.password);
        btnsignup =findViewById(R.id.signup);
        btnsignin =findViewById(R.id.login);
        database = AppDataBase.getAppDatabase(getApplicationContext());
         /*if(mPreferences.contains("email")){

            email.setText(mPreferences.getString("email",""));


        }*/


        btnsignup.setOnClickListener(e-> {
            intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);


        });
        btnsignin.setOnClickListener(e-> {
            String emailcheck = email.getText().toString();
            String pwdcheck = password.getText().toString();

            if(database.userDAO().login(emailcheck,pwdcheck)) {
                SharedPreferences.Editor ed = mPreferences.edit();
                ed.putString("email", email.getText().toString());
                ed.apply();
                Toast.makeText(LoginActivity.this, "user logged", Toast.LENGTH_SHORT).show();
                String username =emailcheck;

                intent = new Intent(LoginActivity.this, CinemaActivity.class);
                //.putExtra("username",username)
                startActivity(intent);
                System.out.println(database.userDAO().getAll());
                System.out.println(username);

            }else if (emailcheck.isEmpty() || pwdcheck.isEmpty()){
                Toast.makeText(LoginActivity.this, "fill all fields!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(LoginActivity.this, "credentials invalid!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}