package com.example.testinterface.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testinterface.DAO.UserDAO;
import com.example.testinterface.Entity.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDAO userDAO();
    public static AppDataBase getAppDatabase(Context context){
        if(instance== null) {
            instance= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"rmovies_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
