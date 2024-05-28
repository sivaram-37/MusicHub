package com.musichub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musichub.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	Song findByName(String name);

}
