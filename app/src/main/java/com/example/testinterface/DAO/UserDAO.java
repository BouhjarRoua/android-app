package com.example.testinterface.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testinterface.Entity.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertOne(User user);
    @Delete
    void delete(User user);
    @Query("SELECT * FROM user")
    List<User> getAll();
    @Query("SELECT EXISTS (SELECT * FROM user where username=:username)")
    boolean is_taken(String username);

    @Query("SELECT EXISTS (SELECT * FROM user where email=:email AND password=:password)")
    boolean login(String email,String password);

}
