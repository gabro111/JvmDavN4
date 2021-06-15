package ge.btu.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetMoviesOutput {
    List<MovieDTO> movies;
}
