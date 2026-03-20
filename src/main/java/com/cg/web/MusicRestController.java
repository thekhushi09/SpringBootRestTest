package com.cg.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Music;
import com.cg.repo.MusicRepo;

@RestController
@RequestMapping("/music")
public class MusicRestController {
	
	@Autowired
	private MusicRepo musicRepo;
	
	@GetMapping("/home")
	public ResponseEntity<String> sayHello(){
		
		return new ResponseEntity<>("Hi welcome",HttpStatus.OK);
	}
	
	@PostMapping("/addtrack")
	public ResponseEntity<String> addTrack(@RequestBody Music music){
		Music savedMusic=musicRepo.save(music);
		return new ResponseEntity<String>("Music added and Id is"+ savedMusic.getTrackId(),HttpStatus.CREATED);
	}
	
	@GetMapping("/gettracks")
	public ResponseEntity<List<Music>> viewAllTracks(){
		List<Music> musics=musicRepo.findAll();
		return new ResponseEntity<>(musics,HttpStatus.OK);
	}
	
	@GetMapping("/title")
	public ResponseEntity<List<Music>> viewByTitle(@RequestParam("title") String title){
		List<Music> musics=musicRepo.findBytrackTitle(title);
		return new ResponseEntity<>(musics,HttpStatus.OK);
	}
	
	@GetMapping("/id/{mid}")
	public ResponseEntity<Object> viewMovieById(@PathVariable("mid") Integer trackId) {
		Optional<Music> optMusic= musicRepo.findById(trackId);
		if(optMusic.isPresent()) {
			return new ResponseEntity<Object>(optMusic.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Music Not found",HttpStatus.NOT_FOUND);
		}
		
	}
	

}
