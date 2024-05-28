package com.musichub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/login")
	public String signin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "registeration";
	}
	
	@GetMapping("/addsong")
	public String addSong() {
		return "song";
	}
	
	@GetMapping("/play")
	public String playSong() {
		return "viewsongs";
	}
	
	
	
	
}
