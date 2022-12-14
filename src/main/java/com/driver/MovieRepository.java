package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

@Repository
@Component
public class MovieRepository {
    //HashMap considered as DB
    HashMap<String,Movie> movies = new HashMap<>();
    HashMap<String,Director> directors = new HashMap<>();
//    HashMap<Movie,Director> moviesDirectors = new HashMap<>();
    HashMap<String,List<String>> movieDirectorDatabase =new HashMap<>();

    //Add new movie
    public void addMovieInDB(Movie movie){
        movies.put(movie.getName(),movie);
    }

    //Add new director
    public void addDirectorInDB(Director director){
        directors.put(director.getName(),director);

    }

    //Add Movie and Director pair
    public String addMovieDirectorPairInDB(String movieName, String directorName){
        //check director's name exist in DB or not
        List<String> list = new ArrayList<>();
        if (movieDirectorDatabase.containsKey(directorName)) {
            list = movieDirectorDatabase.get(directorName);
            list.add(movieName);
            movieDirectorDatabase.put(directorName, list);
        } else {
            list.add(movieName);
            movieDirectorDatabase.put(directorName, list);
        }
        return "Successful!!!";
    }

    //Get all movies
    public List<String> getAllMoviesFromDB(){
        List<String> moviesList = new ArrayList<>();

        for(Movie movie : movies.values()){
            moviesList.add(movie.getName());
        }

        return moviesList;
    }
    //Get movie by name
    public Movie getMovieByNameFromDB(String name){
        if(movies.containsKey(name)){
            return movies.get(name);
        }
        return null;
    }

    //Get director by name
    public Director getDirectorByNameFromDB(String name){
        if(directors.containsKey(name)){
            return directors.get(name);
        }
        return null;
    }

    //Get movies by director's name
    public List<String> getMoviesByDirectorNameFromDB(String directorName){
       return  movieDirectorDatabase.get(directorName);
    }

    //Delete director by name
    public String deleteDirectorByNameFromDB(String directorName){
        List<String> list = new ArrayList<>();
        list = movieDirectorDatabase.get(directorName);

        movieDirectorDatabase.remove(directorName);
        directors.remove(directorName);

        for (String movieName : list) {
            movies.remove(movieName);
        }
        return "Director has been successfully deleted!!!";
    }


    //Delete all directors and movies
    public String deleteAllDirectorsFromDB(){
        for(String directorName: movieDirectorDatabase.keySet()){
            deleteDirectorByNameFromDB(directorName);
        }
        return "All directors and movies associate with them are deleted!!!";
    }
//
//    //OPTIONAL (REMOVE IT LATER)
//    //Get all directors
//    public List<Director> getAllDirectorsInDB(){
//        List<Director> directorsList = new ArrayList<>();
//
//        for(Director director : directors.values()){
//            directorsList.add(director);
//        }
//
//        return directorsList;
//    }

}

