package com.boot.ete.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.ete.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>
{
		
	List<Movie>	findAllByHeroOfMovie(List<String> actorName);
		
}
