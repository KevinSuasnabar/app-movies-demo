package pe.suasnabar.appmovies.services;

import pe.suasnabar.appmovies.dto.request.CreateMovieRequest;
import pe.suasnabar.appmovies.dto.request.FavouriteMovieRequest;
import pe.suasnabar.appmovies.model.entity.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> getMovies();

    List<Movie> getFavouritesMoviesByUserId(Integer userId);

    Movie addToFavourites(FavouriteMovieRequest request);

    Movie createMovie(CreateMovieRequest request);
}
