package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
       private  Button btn;
       private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  TextView tv=findViewById(R.id.textView);*/
        btn=findViewById(R.id.button);



        btn.setOnClickListener(e-> {
           // intent = new Intent(MainActivity.this, LoginActivity.class);
            intent = new Intent(MainActivity.this, LoginActivity.class);

            startActivity(intent);
            finish();
           // Toast.makeText(this,"salut 5SAE3",Toast.LENGTH_LONG).show();
        });





    }
}