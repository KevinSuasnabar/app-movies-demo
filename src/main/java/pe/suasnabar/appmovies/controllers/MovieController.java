package pe.suasnabar.appmovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.suasnabar.appmovies.dto.request.CreateMovieRequest;
import pe.suasnabar.appmovies.dto.request.FavouriteMovieRequest;
import pe.suasnabar.appmovies.model.entity.Movie;
import pe.suasnabar.appmovies.services.IMovieService;

import java.util.List;


@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    IMovieService iMovieService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<?> getMovies() {
        return ResponseEntity.ok().body(iMovieService.getMovies());
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<?> getFavouriteMoviesByUserId(@PathVariable Integer userId) {
        List<Movie> response = iMovieService.getFavouritesMoviesByUserId(userId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-favourite")
    @ResponseBody
    public ResponseEntity<?> addToFavourites(@RequestBody FavouriteMovieRequest request) {
        return ResponseEntity.ok().body(iMovieService.addToFavourites(request));
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> createMovie(@RequestBody CreateMovieRequest request) {
        return ResponseEntity.ok().body(iMovieService.createMovie(request));
    }

    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok().body("Hello world 4!!!.");
    }

}
