package com.finalproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.api.output.TrailerOutput;
import com.finalproject.dto.TrailerDTO;
import com.finalproject.service.ITrailerService;

@RestController
public class TrailerAPI {

	@Autowired
	private ITrailerService trailerService;
	
	@PostMapping(value = "/trailer")
	public TrailerDTO createTrailer(@RequestBody TrailerDTO model) {
		return trailerService.save(model);
	}

	@PutMapping(value = "/trailer/{id}")
	public TrailerDTO updateTrailer(@RequestBody TrailerDTO model, @PathVariable long id) {
		model.setId(id);
		return trailerService.save(model);
	}
	
	@DeleteMapping(value = "/trailer")
	public void deleteActor(@RequestBody long[] ids) {
		trailerService.delete(ids);
	}
	
	@GetMapping(value = "/trailer/movie/{id}")
	public TrailerOutput showTrailerByMovie(@PathVariable long id) {
		TrailerOutput result = new TrailerOutput();
		result.setTrailerResult(trailerService.findAllTrailerByMovie(id));
		return result;
	}
	
}
