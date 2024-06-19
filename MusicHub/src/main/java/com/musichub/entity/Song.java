package com.musichub.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;
	private String artist;
	private String albam;
	private String link;
	
	@ManyToMany
	private List<Playlist> playlists;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(int id, String name, String artist, String albam, String link, List<Playlist> playlists) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.albam = albam;
		this.link = link;
		this.playlists = playlists;
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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbam() {
		return albam;
	}

	public void setAlbam(String albam) {
		this.albam = albam;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", albam=" + albam + ", link=" + link
				+ ", playlists=" + playlists + "]";
	}

	
}
