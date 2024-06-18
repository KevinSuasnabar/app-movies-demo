package pe.suasnabar.appmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.suasnabar.appmovies.model.entity.UserFavouriteMovies;

import java.util.List;

@Repository
public interface UserFavouriteMoviesRepository extends JpaRepository<UserFavouriteMovies, Integer> {
    @Query("SELECT u.movieId FROM UserFavouriteMovies u WHERE u.userId = :userId")
    List<Integer> findMovieIdsByUserId(@Param("userId") Integer userId);
}
