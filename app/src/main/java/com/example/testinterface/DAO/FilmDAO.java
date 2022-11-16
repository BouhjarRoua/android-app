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
    @Query("DELETE FROM film where id = :id")
    void deleteById(int id);
    @Query("SELECT * FROM film where cinema = :cinema")
    List<Film> getByCinema(String cinema);
    @Query("DELETE  FROM film")
    void deleteAll();
    @Query( "UPDATE film SET participant = :participant where id = :id ")
    int reserve (int id,int participant);
    @Query("SELECT id FROM film where id = :id")
    int getId(int id);
    @Query("SELECT * FROM film where id = :id")
    Film findById(int id);
    @Query("SELECT participant FROM film ")
    int getParticipant();



}
