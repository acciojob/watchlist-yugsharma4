package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovieInDB(Movie movie){
        movieRepository.addMovieInDB(movie);
    }

    public void addDirectorInDB(Director director){
        movieRepository.addDirectorInDB(director);
    }

    public String addMovieDirectorPairInDB(String movieName, String directorName){
        return movieRepository.addMovieDirectorPairInDB(movieName,directorName);
    }

    public List<Movie> getAllMoviesFromDB(){
        return movieRepository.getAllMoviesFromDB();
    }

    public Movie getMovieByNameFromDB(String name){
        return movieRepository.getMovieByNameFromDB(name);
    }

    public Director getDirectorByNameFromDB(String name){
        return movieRepository.getDirectorByNameFromDB(name);
    }

    public List<Movie> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorNameFromDB(name);
    }

    public String deleteDirectorByNameFromDB(String name){
        return movieRepository.deleteDirectorByNameFromDB(name);
    }

    public String deleteAllDirectorsFromDB(){
        return movieRepository.deleteAllDirectorsFromDB();
    }
    //OPTIONAL (REMOVE IT LATER)
    public List<Director> getAllDirectorsFromDB(){
        return movieRepository.getAllDirectorsInDB();
    }
}
