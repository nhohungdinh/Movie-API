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

import com.finalproject.api.output.ActorOutput;
import com.finalproject.dto.ActorDTO;
import com.finalproject.service.IActorService;

@RestController
public class ActorAPI {
	@Autowired
	private IActorService actorService;

	@PostMapping(value = "/actor")
	public ActorDTO createActor(@RequestBody ActorDTO model) {
		return actorService.save(model);
	}

	@PutMapping(value = "/actor/{id}")
	public ActorDTO updateActor(@RequestBody ActorDTO model, @PathVariable long id) {
		model.setId(id);
		return actorService.save(model);
	}
	
	@DeleteMapping(value = "/actor")
	public void deleteActor(@RequestBody long[] ids) {
		actorService.delete(ids);
	}
	
	@GetMapping(value = "/actor")
	public ActorOutput showActorByActorname(@RequestParam(value = "actorname", required = false) String actor) {
		ActorOutput result = new ActorOutput();
		if (actor == null) {
			result.setActorResult(actorService.findAll());
		}else {
			result.setActorResult(actorService.findAllActorByName(actor));
		}
		return result;
	}
	
	@GetMapping(value = "/actor/{id}")
	public ActorDTO showActorById(@PathVariable long id) {
		return actorService.findActorById(id);
	}
	
	@GetMapping(value = "/actor/movie/{id}")
	public ActorOutput showActorByMovieId(@PathVariable long id) {
		ActorOutput result = new ActorOutput();
		result.setActorResult(actorService.findAllActorByMovieId(id));
		return result;
	}
}
