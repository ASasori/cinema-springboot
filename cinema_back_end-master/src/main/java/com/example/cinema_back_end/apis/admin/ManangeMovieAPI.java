package com.example.cinema_back_end.apis.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema_back_end.dtos.MovieDTO;
import com.example.cinema_back_end.services.IMovieService;

@RestController
@RequestMapping("/api/admin/movies")
public class ManangeMovieAPI {
	@Autowired
	private IMovieService movieService;
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAllMovie() {
		return new ResponseEntity<>(movieService.findAll(),HttpStatus.OK);
	}
}
