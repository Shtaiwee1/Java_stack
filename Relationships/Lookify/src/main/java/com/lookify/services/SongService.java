package com.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lookify.models.Song;
import com.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	 
	 public SongService(SongRepository songRepository) {
	     this.songRepository = songRepository;
	 }
	 // returns all the song
	 public List<Song> allSongs() {
	     return songRepository.findAll();
	 }
	 // create a new song
	 public Song createSong(Song e) {
	     return songRepository.save(e);
	 }
	 
	// retrieves an song
		public Song findSong(Long id) {
			Optional<Song> optionalSong = songRepository.findById(id);
			if (optionalSong.isPresent()) {
				return optionalSong.get();
			} else {
				return null;
			}
		}
	 
	//Updates an song
	 public Song updateSong(Long id, Song song) {
		Song l = findSong(id);
			l.setTitle(song.getTitle());
			l.setArtist(song.getArtist());
			l.setRating(song.getRating());
			return songRepository.save(l);
		}
	 
	//deletes an song
	 public void deleteSong(Long id) {
			Song song = this.findSong(id);
			songRepository.delete(song);

		}
	 
	 //retrieves all songs with a given artist name
	 public List<Song> findByArtist(String artistname) {
			return songRepository.findByArtistContainsAllIgnoreCase(artistname);

		}
	 
	// highest ten rating songs

	 public List<Song> topTen() {
			return songRepository.findTop10ByOrderByRatingDesc();

		}
			

}
