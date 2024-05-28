package com.musichub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musichub.entity.Song;
import com.musichub.repository.SongRepository;
import com.musichub.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepository;
	
	@Override
	public void addSong(Song song) {
		songRepository.save(song);
	}

	@Override
	public boolean isSongExist(String name) {
		Song song=songRepository.findByName(name);
		if(song==null) {
			return false;
		}
		return true;
		
	}

	@Override
	public List<Song> viewAllSongs() {
		List<Song> songs = songRepository.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
		
	}

}
