package com.musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.musichub.entity.Playlist;
import com.musichub.entity.Song;
import com.musichub.service.PlaylistService;
import com.musichub.service.SongService;

@Controller
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	@Autowired
	SongService songService;

	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songlist = songService.viewAllSongs();
		model.addAttribute("songs", songlist);
		return "playlist";
	}

	@PostMapping("/saveplaylist")
	public String storePlaylist(@ModelAttribute Playlist playlist) {
		playlistService.savePlaylist(playlist);
		List<Song> songs = playlist.getSongs();
		for (Song song : songs) {
			song.getPlaylists().add(playlist);
			songService.updateSong(song);
		}

		return "adminhome";
	}

	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		boolean subscriptionStatus = true;

		List<Playlist> playlist = playlistService.viewAllPlaylists();
		model.addAttribute("lists", playlist);

		if (subscriptionStatus) {
			return "viewplaylists";
		} else {
			return "paymentform";
		}

	}

	

}
