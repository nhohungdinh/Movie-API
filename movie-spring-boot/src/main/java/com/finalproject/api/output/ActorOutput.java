package com.finalproject.api.output;

import java.util.ArrayList;
import java.util.List;

import com.finalproject.dto.ActorDTO;

public class ActorOutput {
	List<ActorDTO> actorResult = new ArrayList<>();

	public List<ActorDTO> getActorResult() {
		return actorResult;
	}

	public void setActorResult(List<ActorDTO> actorResult) {
		this.actorResult = actorResult;
	}
}
