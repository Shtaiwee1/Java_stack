package com.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lookify.models.Song;
import com.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
    public String Songs(Model model , @ModelAttribute("song") Song song) {
		List<Song>songs = songService.allSongs();
		model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
	
	@GetMapping("/songs/new")
    public String newSong(Model model , @ModelAttribute("song") Song song) {
		List<Song>songs = songService.allSongs();
		model.addAttribute("songs", songs);
        return "create.jsp";
	}
	
	
	@PostMapping("/songs")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="artist") String searchQuery, Model model) {
		List<Song> songs = songService.findByArtist(searchQuery);
		model.addAttribute("songs", songs);
		model.addAttribute("result", searchQuery);
		return "searchartist.jsp";
	}
	
	
	//@GetMapping("/search/{artistname}")
	//public String edit(@PathVariable("artistname") String artistname, Model model) {
		//List<Song> song = songService.findByArtist(artistname);
			 // model.addAttribute("song", song);
			 // model.addAttribute("result", artistname);
			//  return "searchartist.jsp"; }
	
	@GetMapping("/search/topTen")
	public String findTop10ByOrderByRatingDesc(Model model) {
		model.addAttribute("songs", songService.topTen());
		return "topTen.jsp";
	}
	
	
	
	  @GetMapping("/songs/{id}/edit") public String edit(@PathVariable("id") Long
	  id, Model model) { Song song = songService.findSong(id);
	  model.addAttribute("song", song); return "edit.jsp"; }
	 
	
	/*
	 * @PutMapping("/songs/{id}/edit") public String update(@PathVariable("id") Long
	 * id,@Valid @ModelAttribute("song") Song song, BindingResult result) {
	 * if(result.hasErrors()) { return "edit.jsp"; }else {
	 * songService.updateSong(id,song); return "redirect:/songs"; }
	 * 
	 * }
	 */
	
	@GetMapping("/songs/{id}")
	public String index(Model model,@PathVariable("id")Long id) {
	Song song = songService.findSong(id);
	model.addAttribute("song", song);
	return "info.jsp";
}
	
	
	@DeleteMapping("/songs/{id}")
	    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
		    }


}
