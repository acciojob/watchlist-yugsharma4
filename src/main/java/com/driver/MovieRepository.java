package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class MovieRepository {
    //HashMap considered as DB
    HashMap<String,Movie> movies = new HashMap<>();
    HashMap<String,Director> directors = new HashMap<>();
    HashMap<Movie,Director> moviesDirectors = new HashMap<>();

    //Add new movie
    public void addMovieInDB(Movie movie){
        movies.put(movie.getName(),movie);
//        System.out.println(movies.containsKey(movie.getName()));
    }

    //Add new director
    public void addDirectorInDB(Director director){
        directors.put(director.getName(),director);

    }

    //Add Movie and Director pair
    public String addMovieDirectorPairInDB(String movieName, String directorName){
        //check movie and director's name exist in DB or not
        boolean isMovieExist = movies.containsKey(movieName);
        boolean isDirectorExist = directors.containsKey(directorName);

        if(isMovieExist && isDirectorExist){
               moviesDirectors.put(movies.get(movieName),directors.get(directorName));
               return "Movie and Director pair has been added successfully!!!";
        }else if(!isMovieExist && isDirectorExist){
               return  "Movie doesn't exist in DB!!!";
        }
        else if(isMovieExist && !isDirectorExist){
               return  "Director doesn't exist in DB!!!";
        }else {
               return "Movie and Director are not found!!!";
        }
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
    public List<String> getMoviesByDirectorNameFromDB(String name){
        List<String> directorMovies = new ArrayList<>();

        for(Movie movie : moviesDirectors.keySet()){
            if(moviesDirectors.get(movie).getName().equals(name)){
                directorMovies.add(movie.getName());
            }
        }
        return directorMovies;
    }

    //Delete director by name
    public String deleteDirectorByNameFromDB(String name){
        boolean isDirectorExist = directors.containsKey(name);

        if(isDirectorExist){
            directors.remove(name);
            movies.remove(name);
            return "Director has been successfully deleted!!!";
        }
        return "Director does not exist!!!";
    }

    //Delete all directors and movies
    public String deleteAllDirectorsFromDB(){
        for(Movie movie : moviesDirectors.keySet()){
            movies.remove(movie.getName());
            directors.remove(moviesDirectors.get(movie).getName());
        }
        moviesDirectors.clear();
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

