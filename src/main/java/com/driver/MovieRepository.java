package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private HashMap<String , Movie> movieMap;
    private HashMap<String , Director> directorMap;
    private HashMap<String , List<String>> DirMovieMap;

public MovieRepository(){
    this.movieMap = new HashMap<>();
    this.directorMap = new HashMap<>();
    this.DirMovieMap = new HashMap<>();
}

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void createMovieDirectorPair(String movie , String director) {
        if (movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if (DirMovieMap.containsKey(director)) currentMovies = DirMovieMap.get(director);
            currentMovies.add(movie);
            DirMovieMap.put(director, currentMovies);

        }
    }
    public Movie findMovie(String name){
        return movieMap.get(name);
    }
    public Director findDirector(String name){
        return directorMap.get(name);
    }

    public List<String> findMoviesFromDirector(String director){

        List<String> moviesList = new ArrayList<String>();
        if(DirMovieMap.containsKey(director)) moviesList = DirMovieMap.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){

       return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(DirMovieMap.containsKey(director)){
            movies = DirMovieMap.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            DirMovieMap.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: DirMovieMap.keySet()){
            for(String movie: DirMovieMap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }

}
