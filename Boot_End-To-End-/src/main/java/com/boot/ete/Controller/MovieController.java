package com.boot.ete.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ete.Entity.Movie;
import com.boot.ete.Service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService service;
	
	@RequestMapping(value = "/uploadingMovie", method = RequestMethod.POST)
	@ResponseBody
	public String createMovie(@RequestBody Movie movie)
	{
		service.createNewMovie(movie);
		return "Movie uploaded Successfully";
	}
	
	
	@RequestMapping(value = "/showAllMovies", method = RequestMethod.GET)
	public String getAllMovies(Model model)
	{
		List<Movie> allMovies = new ArrayList<>();
		
		allMovies = service.showAllMovies();
		
		model.addAttribute("movies", allMovies);
		
		return "movie";	
	}
	
	
	@RequestMapping(value = "/showMovieOf/{actorName}", method = RequestMethod.GET)
	public String getMovieByActor(@PathVariable("actorName") List<String> actorName,
			Model model)
	{
		
		List<Movie> movieByActorName = new ArrayList<Movie>();
		
		movieByActorName = service.getMovieByActorName(actorName);
		
		model.addAttribute("heroOfMovie", movieByActorName);
		
		model.addAttribute(actorName);
		
		return "movieByActor";
	}
	
	
	
	
	
	
	
	
	
	
}
