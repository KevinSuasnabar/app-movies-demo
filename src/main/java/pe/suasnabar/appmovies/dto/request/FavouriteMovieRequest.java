package pe.suasnabar.appmovies.dto.request;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteMovieRequest {

    private Integer userId;

    private Integer movieId;
}
