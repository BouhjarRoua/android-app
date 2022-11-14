package com.example.testinterface.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "film")
public class Film {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "poster")
    private String poster;
    @ColumnInfo(name = "cinema")
    private String cinema;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "participant")
    private int participant;

    public Film() {
    }

    public Film(String name, String poster, String cinema, String description) {
        this.name = name;
        this.poster = poster;
        this.cinema = cinema;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster='" + poster + '\'' +
                ", cinema='" + cinema + '\'' +
                ", description='" + description + '\'' +
                ", participant='" + participant + '\'' +
                '}';
    }
}
