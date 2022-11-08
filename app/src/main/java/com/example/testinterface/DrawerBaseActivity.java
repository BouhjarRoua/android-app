package com.example.testinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    private SharedPreferences mPreferences;
    public static final String sharedPrefFile = "MyAuth";
    @Override
    public void setContentView(View view) {
        drawerLayout =(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base,null);
        FrameLayout container =drawerLayout.findViewById(R.id.activitycontainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        NavigationView navigationView =drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu nav_Menu = navigationView.getMenu();
        System.out.println(mPreferences.getString("email",""));
        if(mPreferences.getString("email","").equals("admin@gmail.com")){


            nav_Menu.findItem(R.id.nav_addfilm).setVisible(true);
            nav_Menu.findItem(R.id.nav_details).setVisible(true);

        }else{
            nav_Menu.findItem(R.id.nav_addfilm).setVisible(false);
            nav_Menu.findItem(R.id.nav_details).setVisible(false);
        }


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

            switch (item.getItemId()) {
                case R.id.nav_cinema:
                    startActivity(new Intent(this, CinemaActivity.class));
                    overridePendingTransition(0, 0);
                    break;
                case R.id.nav_profile:
                    startActivity(new Intent(this, ProfileActivity.class));
                    overridePendingTransition(0, 0);
                    break;
                case R.id.nav_addfilm:
                    startActivity(new Intent(this, AddFilmActivity.class));
                    overridePendingTransition(0, 0);
                    break;
                case R.id.nav_details:
                    startActivity(new Intent(this,DetailsActivity.class));
                    overridePendingTransition(0, 0);
                    break;


        }
        return false;
    }

    protected void allocateActivityTitle(String titleString){
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(titleString);
        }
        }

}