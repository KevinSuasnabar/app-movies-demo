package pe.suasnabar.appmovies.model.entity;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "user_favourite_movies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFavouriteMovies implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer movieId;
}
