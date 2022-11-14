package com.example.testinterface.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testinterface.DAO.FilmDAO;
import com.example.testinterface.DAO.UserDAO;
import com.example.testinterface.Entity.Film;
import com.example.testinterface.Entity.User;

@Database(entities = {User.class,Film.class},version = 3,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDAO userDAO();
    public abstract FilmDAO filmDAO();
    public static AppDataBase getAppDatabase(Context context){
        if(instance== null) {
            instance= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"rmovies_db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
