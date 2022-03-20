package com.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lookify.models.Song;



@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	// this method retrieves all the books from the database
    List<Song> findAll();
 // this method retrieves a song with a given artist name from the database
    //List<Song> findByArtistContaining(String artist);
    List<Song> findByArtistContainsAllIgnoreCase(String search);
  //this method retrieves top ten songs with the highest rating
  	List<Song> findTop10ByOrderByRatingDesc();

   
}
