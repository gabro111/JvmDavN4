package ge.btu.demo.service;

import ge.btu.demo.dto.*;
import ge.btu.demo.model.*;

public interface MovieService {

    void addMovie(AddMovieInput addMovieInput);
    void deleteMovie(DeleteMovieInput deleteMovieInput);
    GetMoviesOutput getMovies(GetMoviesInputFilter getMoviesInputFilter);
    Movie getMovie(GetMovieInput getMovieInput);

}
