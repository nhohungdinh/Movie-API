package com.finalproject.api.output;

import java.util.ArrayList;
import java.util.List;

import com.finalproject.dto.TrailerDTO;

public class TrailerOutput {
	List<TrailerDTO> trailerResult = new ArrayList<TrailerDTO>();

	public List<TrailerDTO> getTrailerResult() {
		return trailerResult;
	}

	public void setTrailerResult(List<TrailerDTO> trailerResult) {
		this.trailerResult = trailerResult;
	}
	
}
