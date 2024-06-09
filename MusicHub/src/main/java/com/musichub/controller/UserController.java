package com.musichub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musichub.entity.Song;
import com.musichub.entity.User;
import com.musichub.service.SongService;
import com.musichub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	SongService songService;

	@PostMapping("/registered")
	public String adduser(@ModelAttribute User u) {
		
		String email = u.getEmail(); 
		boolean exist = userservice.isExist(email);
		
		if(!exist) {
			userservice.storeuser(u);	
		}
		else {
			System.out.println("User already exist");
		}
		return "login";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,Model model) {
		
		boolean b=userservice.validate(email,password);
		if(b) {
			session.setAttribute("email", email);
			String role = userservice.fetchRole(email);
			if(role.equals("admin")) {
				return "adminhome";
			}
			else{
				User user = userservice.getUser(email);
				boolean premiumStatus = user.getPremium();
				List<Song> fetchAllSongs=songService.viewAllSongs();
				model.addAttribute("songs", fetchAllSongs);
				model.addAttribute("ispremium", premiumStatus);
				return "customerhome";
			}
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "login";
	}
	

}
