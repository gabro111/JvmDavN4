package ge.btu.demo.controller;



import ge.btu.demo.dto.*;
import ge.btu.demo.model.Movie;
import ge.btu.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movie-controller")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("add-movie")
    void addMovie(@RequestBody AddMovieInput addMovieInput){

        movieService.addMovie(addMovieInput);
    }


    @PostMapping("delete-movie")
    void deleteMovie(@RequestBody DeleteMovieInput deleteMovieInput){
        movieService.deleteMovie(deleteMovieInput);
    }
    @PostMapping("get-movies")
    GetMoviesOutput getMovies(@RequestBody GetMoviesInputFilter getMoviesInputFilter){
        return movieService.getMovies(getMoviesInputFilter);

    }
    @PostMapping("get-movie")
    Movie getMovie(@RequestBody GetMovieInput getMovieInput){

        return movieService.getMovie(getMovieInput);

    }
}
