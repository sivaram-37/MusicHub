package com.musichub.service;

import java.util.List;

import com.musichub.entity.Song;

public interface SongService {

	void addSong(Song song);

	boolean isSongExist(String name);

	List<Song> viewAllSongs();

	void updateSong(Song song);

	

}
