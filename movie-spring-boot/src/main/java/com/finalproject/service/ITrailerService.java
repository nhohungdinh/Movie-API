package com.finalproject.service;

import java.util.List;

import com.finalproject.dto.TrailerDTO;

public interface ITrailerService {
	TrailerDTO save(TrailerDTO trailerDTO);
	void delete(long[] ids);
	List<TrailerDTO> findAllTrailerByMovie(long id);
}
