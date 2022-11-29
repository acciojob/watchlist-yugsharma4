package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    //Add new movie
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody(required = true) Movie movie){
        movieService.addMovieInDB(movie);
        return new ResponseEntity("Movie added successfully!!!", HttpStatus.CREATED);
    }

    //Add new director
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody(required = true) Director director){
        movieService.addDirectorInDB(director);
        return new ResponseEntity("Director added successfully!!!", HttpStatus.CREATED);
    }

    //Add a pair of existing movie director
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName")String directorName){
        return new ResponseEntity( movieService.addMovieDirectorPairInDB(movieName,directorName),HttpStatus.CREATED);
    }


    //Get All movies
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity(movieService.getAllMoviesFromDB(),HttpStatus.ACCEPTED);
    }

    //Get Movie by name
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        return new ResponseEntity(movieService.getMovieByNameFromDB(name),HttpStatus.ACCEPTED);

    }

    //Get Director by name
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return new ResponseEntity(movieService.getDirectorByNameFromDB(name),HttpStatus.ACCEPTED);

    }

    //Get Movies by Director name
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity(movieService.getMoviesByDirectorName(director),HttpStatus.ACCEPTED);

    }

    //Delete director by his/her name
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName){
        return new ResponseEntity(movieService.deleteDirectorByNameFromDB(directorName),HttpStatus.OK);

    }

    //Delete all directors and movies
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity(movieService.deleteAllDirectorsFromDB(),HttpStatus.OK);
    }
//
//    //OPTIONAL (REMOVE IT LATER)
//    //Get All directors
//    @GetMapping("/movies/get-all-directors")
//    public ResponseEntity<List<Director>> findAllDirectors(){
//        return new ResponseEntity(movieService.getAllDirectorsFromDB(),HttpStatus.OK);
//    }
}

