package com.musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.musichub.entity.Song;
import com.musichub.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songservice;
	
	@PostMapping("/addSong")
	public String storeSong(@ModelAttribute Song song) {
		
		boolean exist=songservice.isSongExist(song.getName());
		if(!exist) {
			songservice.addSong(song);			
			System.out.println("Song saved Successfully");
		}
		else {
			System.out.println("Duplicate Song");
		}
		return "adminhome";
	}
	
	@GetMapping("/playsong")
	public String playSong(Model model) {
		boolean isPremium=true;
		
		List<Song> songlist=songservice.viewAllSongs();
		model.addAttribute("songs",songlist);
		
		if(isPremium) {
			return "viewsongs";
		}
		else {
			return "pay";
		}
		
	}
	
	@GetMapping("/viewsong")
	public String viewSong(Model model) {
		List<Song> songlist=songservice.viewAllSongs();
		model.addAttribute("songs",songlist);
		return "viewsongs";
	}
	
	
	
}
