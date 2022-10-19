package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testinterface.databinding.ActivityProfileBinding;

public class ProfileActivity extends DrawerBaseActivity {


    ActivityProfileBinding activityProfileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding =activityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");
    }
}