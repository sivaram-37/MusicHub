package com.musichub.service;

import java.util.List;

import com.musichub.entity.Playlist;

public interface PlaylistService {

	void savePlaylist(Playlist playlist);

	List<Playlist> viewAllPlaylists();

	

	

	

}
