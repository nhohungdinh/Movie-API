package com.finalproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finalproject.converter.ActorConverter;
import com.finalproject.converter.MovieConverter;
import com.finalproject.converter.TrailerConverter;
import com.finalproject.dto.ActorDTO;
import com.finalproject.dto.MovieDTO;
import com.finalproject.dto.TrailerDTO;
import com.finalproject.entity.ActorEntity;
import com.finalproject.entity.GenreEntity;
import com.finalproject.entity.MovieEntity;
import com.finalproject.entity.TrailerEntity;
import com.finalproject.repository.ActorRepository;
import com.finalproject.repository.GenreRepository;
import com.finalproject.repository.MovieRepository;
import com.finalproject.service.IMovieService;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private MovieConverter movieConverter;

	@Autowired
	private TrailerConverter trailerConverter;

	@Autowired
	private ActorConverter actorConverter;

	@Override
	public MovieDTO save(MovieDTO movieDTO) {
		MovieEntity movieEntity = new MovieEntity();
		if (movieDTO.getId() != null) {
			MovieEntity oldEntity = movieRepository.findOne(movieDTO.getId());
			movieEntity = movieConverter.toEntity(movieDTO, oldEntity);
		} else {
			movieEntity = movieConverter.toEntity(movieDTO);
		}
		GenreEntity genreEntity = genreRepository.findOneByCode(movieDTO.getGenreCode());
		movieEntity.setGenre(genreEntity);
		List<ActorDTO> actorDTOs = movieDTO.getActors();
		List<ActorEntity> actorEntities = new ArrayList<ActorEntity>();
		for (ActorDTO actor : actorDTOs) {
			ActorEntity actorEntity = actorRepository.findOne(actor.getId());
			if (actorEntity == null) {
				continue;
			}
			actorEntities.add(actorEntity);
		}
		movieEntity.setActor(actorEntities);
		movieRepository.save(movieEntity);
		return movieConverter.toDTO(movieEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
//			TrailerEntity trailerEntity = trailerRepository.findOneByMovie(movieRepository.findOne(item));
//			if (trailerEntity != null) {
//				trailerRepository.delete(trailerEntity);
//			}
			movieRepository.delete(item);
		}
	}

	@Override
	public List<MovieDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieDTO> findAllMovieByGenre(long id) {
		List<MovieDTO> results = new ArrayList<>();
		GenreEntity genreEntity = genreRepository.findOne(id);
		List<MovieEntity> movieEntities = genreEntity.getMovies();
		for (MovieEntity mv : movieEntities) {
			MovieDTO movieDTO = movieConverter.toDTO(mv);
			List<ActorDTO> listActor = new ArrayList<>();
			List<ActorEntity> actorEn = mv.getActor();

			for (ActorEntity actor : actorEn) {
				ActorDTO actorDTO = actorConverter.toDTO(actor);
				listActor.add(actorDTO);
			}
			movieDTO.setActors(listActor);
			List<TrailerDTO> listTrailer = new ArrayList<>();
			List<TrailerEntity> trailerEntities = mv.getTrailers(); // lấy ra 1 list trailer, 1 bộ phim có nhiều trailer
			for (TrailerEntity trailer : trailerEntities) {
				TrailerDTO trailerDTO = trailerConverter.toDTO(trailer);
				listTrailer.add(trailerDTO);
			}
			movieDTO.setTrailers(listTrailer); // thêm list trailer ứng với mỗi bộ phim vào kết quả trả về cho client
			results.add(movieDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) movieRepository.count();
	}

	@Override
	public List<MovieDTO> findAllMovieByActorName(String name) {
		List<MovieDTO> results = new ArrayList<>();
		List<ActorEntity> actorEntities = actorRepository.findAllByName(name); // lấy tất cả Actor có name = name, có
																				// actor name trùng nhau
		for (ActorEntity item : actorEntities) {
			long actorId = item.getId(); // lấy ra actor ID, actor ID là khác nhau
			List<MovieEntity> movieEntities = movieRepository.findByActor_Id(actorId); // lấy ra những bộ phim của những
																						// actor có tên trùng nhau, ID
																						// khác nhau
			for (MovieEntity mv : movieEntities) {
				MovieDTO movieDTO = movieConverter.toDTO(mv);
				List<ActorDTO> listActor = new ArrayList<>();
				List<ActorEntity> actorEn = mv.getActor();

				for (ActorEntity actor : actorEn) {
					ActorDTO actorDTO = actorConverter.toDTO(actor);
					listActor.add(actorDTO);
				}
				movieDTO.setActors(listActor);
				List<TrailerDTO> listTrailer = new ArrayList<>();
				List<TrailerEntity> trailerEntities = mv.getTrailers(); // lấy ra 1 list trailer, 1 bộ phim có nhiều
																		// trailer
				for (TrailerEntity trailer : trailerEntities) {
					TrailerDTO trailerDTO = trailerConverter.toDTO(trailer);
					listTrailer.add(trailerDTO);
				}
				movieDTO.setTrailers(listTrailer); // thêm list trailer ứng với mỗi bộ phim vào kết quả trả về cho
													// client
				results.add(movieDTO);
			}
		}
		return results;
	}

	@Override
	public List<MovieDTO> findAllMovieByTitle(String title) {
		List<MovieDTO> results = new ArrayList<>();
		List<MovieEntity> movieEntities = movieRepository.findByTitle(title);
		for (MovieEntity mv : movieEntities) {
			MovieDTO movieDTO = movieConverter.toDTO(mv);
			List<ActorDTO> listActor = new ArrayList<>();
			List<ActorEntity> actorEn = mv.getActor();

			for (ActorEntity actor : actorEn) {
				ActorDTO actorDTO = actorConverter.toDTO(actor);
				listActor.add(actorDTO);
			}
			movieDTO.setActors(listActor);
			List<TrailerDTO> listTrailer = new ArrayList<>();
			List<TrailerEntity> trailerEntities = mv.getTrailers(); // lấy ra 1 list trailer, 1 bộ phim có nhiều
																	// trailer
			for (TrailerEntity trailer : trailerEntities) {
				TrailerDTO trailerDTO = trailerConverter.toDTO(trailer);
				listTrailer.add(trailerDTO);
			}
			movieDTO.setTrailers(listTrailer); // thêm list trailer ứng với mỗi bộ phim vào kết quả trả về cho
												// client
			results.add(movieDTO);
		}
		return results;
	}

	@Override
	public MovieDTO findMovieById(long id) {
		MovieEntity movieEntity = movieRepository.findOne(id);
		MovieDTO movieDTO = movieConverter.toDTO(movieEntity);
		List<ActorDTO> listActor = new ArrayList<>();
		List<ActorEntity> actorEn = movieEntity.getActor();

		for (ActorEntity actor : actorEn) {
			ActorDTO actorDTO = actorConverter.toDTO(actor);
			listActor.add(actorDTO);
		}
		movieDTO.setActors(listActor);
		List<TrailerDTO> listTrailer = new ArrayList<>();
		List<TrailerEntity> trailerEntities = movieEntity.getTrailers(); // lấy ra 1 list trailer, 1 bộ phim có nhiều
																// trailer
		for (TrailerEntity trailer : trailerEntities) {
			TrailerDTO trailerDTO = trailerConverter.toDTO(trailer);
			listTrailer.add(trailerDTO);
		}
		movieDTO.setTrailers(listTrailer); 
		return movieDTO;
	}

}
