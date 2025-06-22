package com.example.musicbasicapp.service;

import com.example.musicbasicapp.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void update(Song song);
    void delete(int id);
}