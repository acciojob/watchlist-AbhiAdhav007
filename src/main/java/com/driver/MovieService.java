package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }


    public void createMovieDirectorPair(String MovieName , String DirName){
         movieRepository.createMovieDirectorPair(MovieName,DirName);
    }

    public Movie findMovie(String name){
        return movieRepository.findMovie(name);
    }

    public Director findDirector(String name){
        return movieRepository.findDirector(name);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);

    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }
}
