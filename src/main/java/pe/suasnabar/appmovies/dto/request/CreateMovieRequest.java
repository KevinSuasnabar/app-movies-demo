package pe.suasnabar.appmovies.dto.request;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {
    private String title;
    private String description;
    private Integer releaseYear;
    private BigDecimal duration;
    private String director;
    private String status;

}
