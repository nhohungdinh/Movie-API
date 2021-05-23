package com.finalproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.api.output.MovieOutput;
import com.finalproject.dto.MovieDTO;
import com.finalproject.service.IMovieService;

@RestController
public class MovieAPI {
	
	@Autowired
	private IMovieService movieService;
	
	@GetMapping(value = "/movie")
	public MovieOutput showMovieByActor(@RequestParam(value = "actorname", required = true) String actor) {
		MovieOutput result = new MovieOutput();
		result.setMovieResult(movieService.findAllMovieByActorName(actor));
		return result;
	}
	
	@GetMapping(value = "/movie/genre/{id}")
	public MovieOutput showMovieByGenre(@PathVariable long id) {
		MovieOutput result = new MovieOutput();
		result.setMovieResult(movieService.findAllMovieByGenre(id));
		return result;
	}
	
	@GetMapping(value = "/movie/{title}")
	public MovieOutput showMovieByTitle(@PathVariable String title) {
		MovieOutput result = new MovieOutput();
		result.setMovieResult(movieService.findAllMovieByTitle(title));
		return result;
	}
	
	@GetMapping(value = "/movie/id/{id}")
	public MovieDTO showMovieById(@PathVariable long id) {
		return movieService.findMovieById(id);
	}
	
	@PostMapping(value = "/movie")
	public MovieDTO createMovie(@RequestBody MovieDTO model) {
		return movieService.save(model);
	}
	
	@PutMapping(value = "/movie/{id}")
	public MovieDTO updateMovie(@RequestBody MovieDTO model, @PathVariable long id) {
		model.setId(id);
		return movieService.save(model);
	}
	
	@DeleteMapping(value = "/movie")
	public void deleteMovie(@RequestBody long[] ids) {
		movieService.delete(ids);
	}
	
}
