package ge.btu.demo.service.impl;

import ge.btu.demo.dto.*;
import ge.btu.demo.model.*;
import ge.btu.demo.repository.MovieRepository;
import ge.btu.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(AddMovieInput addMovieInput) {
        Movie movie = new Movie();
        movie.setTitle(addMovieInput.getTitle());
        movie.setCountry(addMovieInput.getCountry());
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(DeleteMovieInput deleteMovieInput) {

        movieRepository.deleteById(deleteMovieInput.getId());

    }

    @Override
    public GetMoviesOutput getMovies(GetMoviesInputFilter getMoviesInputFilter) {
        List<Movie> movieList = movieRepository.findAll();
        GetMoviesOutput moviesOutput = new GetMoviesOutput();
        List<MovieDTO> movieDTOS = new ArrayList<>();

        for(Movie movie : movieList){
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(movie.getId());
            movieDTO.setCountry(movie.getCountry());
            movieDTO.setTitle(movie.getTitle());
            if(movieDTO.getCountry() == getMoviesInputFilter.getCountry() && movieDTO.getTitle()== getMoviesInputFilter.getTitle()) {
                movieDTOS.add(movieDTO);
            }
            if(getMoviesInputFilter.getTitle() == "" && getMoviesInputFilter.getCountry() == ""){
                movieDTOS.add(movieDTO);
            }
        }
        moviesOutput.setMovies(movieDTOS);
        return moviesOutput;
    }

    @Override
    public Movie getMovie(GetMovieInput getMovieInput) {

        Movie movie = movieRepository.getById(getMovieInput.getId());

        if(movie.getCountry().equals(getMovieInput.getCountry()))
        {
            return movie;
        }
        if(getMovieInput.getCountry().equals("")){
            return movie;
        }
        System.out.println("No Movie With That Country");
        return null;
    }
}
