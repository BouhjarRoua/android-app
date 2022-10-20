package com.example.testinterface.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.testinterface.Entity.Film;

import java.util.List;

@Dao
public interface FilmDAO {
    @Insert
    void insertOne(Film film);
    @Delete
    void delete(Film film);
    @Query("SELECT * FROM film")
    List<Film> getAll();


}
