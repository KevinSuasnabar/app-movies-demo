package pe.suasnabar.appmovies.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.suasnabar.appmovies.dto.request.CreateMovieRequest;
import pe.suasnabar.appmovies.dto.request.FavouriteMovieRequest;
import pe.suasnabar.appmovies.model.entity.Movie;
import pe.suasnabar.appmovies.model.entity.UserFavouriteMovies;
import pe.suasnabar.appmovies.repository.MovieRepository;
import pe.suasnabar.appmovies.repository.UserFavouriteMoviesRepository;
import pe.suasnabar.appmovies.services.IMovieService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    private UserFavouriteMoviesRepository userFavoriteMovieRepository;


    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getFavouritesMoviesByUserId(Integer userId) {
        List<Integer> favoriteMovieIds = userFavoriteMovieRepository.findMovieIdsByUserId(userId);
        return favoriteMovieIds.stream()
                .map(movieRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public Movie addToFavourites(FavouriteMovieRequest request) {
        Optional<Movie> movie = movieRepository.findById(request.getMovieId());
        if (movie.isPresent()) {
            userFavoriteMovieRepository.save(UserFavouriteMovies.builder().movieId(request.getMovieId())
                    .userId(request.getUserId()).build());

            return movie.get();
        }

        System.out.println("No se encontro pelicula.");
        return null;
    }

    @Override
    public Movie createMovie(CreateMovieRequest request) {
        if(request!=null){
            Movie movie = Movie.builder()
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .releaseYear(request.getReleaseYear())
                    .duration(request.getDuration())
                    .director(request.getDirector())
                    .status(request.getStatus())
                    .createdDate(new Date())
                    .updatedDate(new Date())
                    .build();
            Movie movieCreated = movieRepository.save(movie);
            return movieCreated;
        }
        System.out.println("DATOS INCORRECTOS O NULOS");
        return  null;
    }
}
