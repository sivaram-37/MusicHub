package com.musichub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musichub.entity.Playlist;
import com.musichub.repository.PlaylistRepository;
import com.musichub.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void savePlaylist(Playlist playlist) {
		Playlist name = playlistRepository.findByName(playlist.getName());
		if(name==null) {
			playlistRepository.save(playlist);		
		}
		else {
			System.out.println("Duplicate Playlist name");
		}
	}

	@Override
	public List<Playlist> viewAllPlaylists() {
		List<Playlist> playlists = playlistRepository.findAll();
		return playlists;
	}
	
	
}
