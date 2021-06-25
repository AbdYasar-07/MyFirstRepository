package com.boot.ete.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.boot.ete.Entity.Movie;
import com.boot.ete.Repository.MovieRepository;

@Service
public class MovieService {

	
	@Autowired
	private MovieRepository repo;
	
	
	public String createNewMovie(Movie movie)
	{
		try
		{
			 repo.save(movie);
		}
		catch(Exception e)
		{
			HttpStatus.INTERNAL_SERVER_ERROR.value();
		}
		return "Movie Uploaded Successfully";
	}
	
	
	public List<Movie> showAllMovies()
	{
		
		List<Movie> listOfMovies = repo.findAll();
		
		return listOfMovies;
	}
	
	public List<Movie> getMovieByActorName(List<String> actorName)
	{
		List<Movie> movieByActorName = repo.findAllByHeroOfMovie(actorName);
		
		return movieByActorName;
	}
	
	
	
}
